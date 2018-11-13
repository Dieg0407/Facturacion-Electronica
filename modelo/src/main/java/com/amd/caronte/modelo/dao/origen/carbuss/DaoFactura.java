package com.amd.caronte.modelo.dao.origen.carbuss;

import com.amd.caronte.modelo.dao.beans.BeanDetalle;
import com.amd.caronte.modelo.dao.beans.BeanDocumento;
import com.amd.caronte.modelo.dao.origen.DaoOrigen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaoFactura implements DaoOrigen {

    private Connection conexion;

    public DaoFactura(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public List<BeanDocumento> obtenerDocumentos(String fecha, Map<String, Integer[]> registros) {
        List<BeanDocumento> datos = null;

        String notInto = this.definirNotInto(registros);
        String sql = "SELECT  m_sali.sali_p_incodsal AS Transaccion,"
                +"SUBSTRING(TRIM(m_sali.SALI_chFECSAL),1,6) AS periodo,"
                +"m_sali.SALI_chFECSAL AS fechaemision,"
                +"IF(TRIM(m_tipo_docu_impr.TDOI_chNOMTIP)=\"FACTURA\",\"01\",\"03\") AS TIPODOCUMENTO,"
                +"m_sali.SALI_inSITSAL AS ANULADO,"
                +"m_sali.SALI_chSERDOC AS serie,"
                +"m_sali.SALI_chNRODOC AS numero,"
                +"IF(LENGTH(TRIM(m_pers.Pers_chrucdniper))=11,\"6\",\"1\") AS tipocliente,"
                +"m_pers.Pers_chrucdniper AS numcliente,"
                +"m_pers.Pers_chnomcom AS nomcliente,"
                +"m_pers.Pers_chdirper AS direccion,"
                +"m_pers.Pers_chemaper AS email,"
                +"m_sali.SALI_deTOTSAL AS valventaexo,"
                +"m_sali.SALI_deTOTSAL AS totaldoc"
                +" FROM "
                +"carbuss.m_sali"
                +" INNER JOIN m_pers"
                +" ON m_sali.PERS_P_inCODPER=m_pers.Pers_P_incodper"
                +" INNER JOIN m_tipo_docu_impr"
                +" ON m_sali.TDOI_P_inCODTIP=m_tipo_docu_impr.TDOI_P_inCODTIP"
                +" WHERE m_sali.sali_chfecsal=\""+fecha+"\" " + notInto +" "
                + "AND m_tipo_docu_impr.TDOI_chNOMTIP = 'FACTURA' AND m_sali.SALI_inSITSAL <> 4 "
                +" ORDER BY m_sali.TDOI_P_inCODTIP,m_sali.SALI_chNRODOC";

        try(Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            datos = new ArrayList<>();

            while(rs.next()){
                BeanDocumento factura = new BeanDocumento();
                factura.setSerie(rs.getString("serie"));
                factura.setNumero(rs.getInt("numero"));
                factura.setFechaEmision(rs.getString("fechaemision"));
                factura.setTipoDocumento(String.format("%3s",rs.getString("TIPODOCUMENTO")).replace(' ','0'));
                factura.setTipoCliente(rs.getString("tipocliente"));
                factura.setNumeroCliente(rs.getString("numcliente"));
                factura.setNombreCliente(rs.getString("nomcliente"));
                factura.setDireccion(rs.getString("direccion"));
                factura.setEmail(rs.getString("email"));
                factura.setVentaExonerada(rs.getDouble("valventaexo"));
                factura.setCodIgv("20");
                factura.setIgv(0.0);
                factura.setTotal(rs.getDouble("totaldoc"));
                factura.setEstado(0);//ESTADO = SIN EVALUAR
                datos.add(factura);
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }

        return datos;
    }

    @Override
    public List<BeanDetalle> obtenerDetalles(List<BeanDocumento> documentos){
        List<BeanDetalle> detalles = null;

        String into = this.definirInto(documentos);
        String sql = "SELECT v_sali.sali_p_incodsal AS transaccion," +
                "    m_cata.cata_chcodext AS codigo," +
                "    m_cata.cata_chnomcat AS denominacion," +
                "    m_unid.unid_chSUNAT  AS unidad," +
                "    m_sali.SALI_chSERDOC AS serie,"+
                "    m_sali.SALI_chNRODOC AS numero,"+
                "    v_sali.sald_decansal AS cantidad," +
                "    v_sali.sald_depreuni AS valunitario," +
                "    v_sali.sald_detotdet AS valtotal," +
                "    v_sali.estado," +
                "    v_cata_deta.CATD_P_inCODCAT," +
                "    v_cata_deta.CATA_P_inCODCAT " +
                "    FROM v_sali" +
                "    INNER JOIN v_cata_deta " +
                "    ON v_sali.catd_p_incodcat=v_cata_deta.CATD_P_inCODCAT " +
                "    INNER JOIN m_cata " +
                "    ON v_cata_deta.CATA_P_inCODCAT=m_cata.cata_p_incodcat " +
                "    INNER JOIN m_unid " +
                "    ON v_cata_deta.UNID_P_inCODUNI=m_unid.unid_p_incoduni " +
                "    INNER JOIN m_sali " +
                "    ON m_sali.SALI_P_inCODSAL = v_sali.sali_p_incodsal " +
                "    WHERE "+into+" AND v_sali.estado = 1 "+
                "    ORDER BY serie, numero; ";

        try(Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            detalles = new ArrayList<>();
            int sec = 0;
            String identificador = "";
            while (rs.next()){

                if(!identificador.equals(String.format("%s-%d",rs.getString("serie"),rs.getInt("numero")))){
                    sec = 0;
                    identificador = String.format("%s-%d",rs.getString("serie"),rs.getInt("numero"));
                }

                BeanDetalle detalle = new BeanDetalle();
                detalle.setSerie(rs.getString("serie"));
                detalle.setNumero(rs.getInt("numero"));
                detalle.setSec(String.format("%03d",++sec));
                detalle.setCodigo(rs.getString("codigo"));
                detalle.setDescripcion(rs.getString("denominacion"));
                detalle.setUnidad(rs.getString("unidad"));
                detalle.setValorUnitario(rs.getDouble("valunitario"));
                detalle.setCantidad(rs.getDouble("cantidad"));
                detalle.setIgv(0.0);
                detalle.setCodIgv("20");
                detalle.setTotal(rs.getDouble("valtotal"));

                detalles.add(detalle);
            }

        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }

        return detalles;
    }

    private String definirNotInto(Map<String,Integer[]> registros){
        StringBuilder sentencia = new StringBuilder();

        if(registros.keySet().size() != 0){
            sentencia.append(" AND CONCAT (m_sali.SALI_chSERDOC,\"-\",m_sali.SALI_chNRODOC) NOT INTO ( ");

            registros.keySet().forEach(serie -> {

                for(Integer numero : registros.get(serie))
                    sentencia.append(String.format(" \"%s-%d\" ,",serie,numero));
            });
            sentencia.append(" \"\" ) ");
        }

        return sentencia.toString();
    }
    private String definirInto(List<BeanDocumento> documentos){
        StringBuilder sentencia = new StringBuilder();

        if(documentos.size() != 0){
            sentencia.append(" AND CONCAT (m_sali.SALI_chSERDOC,\"-\",m_sali.SALI_chNRODOC) INTO ( ");

            documentos.forEach(doc ->
                    sentencia.append(String.format(" \"%s-%d\" ,",doc.getSerie(),doc.getNumero()))
            );
            sentencia.append(" \"\" ) ");
        }

        return sentencia.toString();
    }
}
