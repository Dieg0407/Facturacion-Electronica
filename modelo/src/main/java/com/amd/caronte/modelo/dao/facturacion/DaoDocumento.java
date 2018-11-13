package com.amd.caronte.modelo.dao.facturacion;

import com.amd.caronte.modelo.dao.Parametro;
import com.amd.caronte.modelo.dao.beans.BeanDocumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDocumento implements DaoFacturacion<BeanDocumento> {
    private Connection conexion;

    public DaoDocumento(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public BeanDocumento obtenerElemento(Parametro parametro) {
        BeanDocumento documento = null;
        String sql = String.format("SELECT * FROM documentos WHERE %s = ?",parametro.getField());

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setObject(1,parametro.getValor(),parametro.getTipo());
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next())
                    documento = this.resultSetToBean(rs);
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            documento = null;
        }

        return documento;
    }

    @Override
    public List<BeanDocumento> listarRegistros(List<Parametro> parametros) {
        List<BeanDocumento> documentos;
        String sql = "SELECT * FROM documentos ";
        if(parametros.size() != 0)
            sql = this.convertirParametros(sql,parametros);

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            int i = 1;
            for(Parametro p : parametros)
                pst.setObject(i++,p.getValor(),p.getTipo());

            try(ResultSet rs = pst.executeQuery()){
                documentos = new ArrayList<>();
                while(rs.next())
                    documentos.add(this.resultSetToBean(rs));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            documentos = null;
        }
        return documentos;
    }

    @Override
    public int borrarRegistros(List<Parametro> parametros) {
        int retorno = -1;

        String sql = "DELETE FROM documentos ";
        if(parametros.size() != 0){
            sql = this.convertirParametros(sql,parametros);
            try(PreparedStatement pst = this.conexion.prepareStatement(sql)){

                int i = 1;
                for(Parametro p : parametros)
                    pst.setObject(i++,p.getValor(),p.getTipo());
                retorno = pst.executeUpdate();

            }
            catch (SQLException e){
                e.printStackTrace(System.err);
            }
        }

        return retorno;
    }

    @Override
    public int actualizarRegistro(BeanDocumento registro) {
        int retorno = -1;

        String sql = "UPDATE documentos\n" +
                "SET\n" +
                "tipo_doc = ?,\n" +
                "fecha_emision = ?,\n" +
                "fecha_vencimiento = ?,\n" +
                "tipo_cliente = ?,\n" +
                "num_cliente = ?,\n" +
                "nom_cliente = ?,\n" +
                "direccion = ?,\n" +
                "distrito = ?,\n" +
                "provincia = ?,\n" +
                "departamento = ?,\n" +
                "email = ?,\n" +
                "venta_afecta = ?,\n" +
                "venta_inafecta = ?,\n" +
                "venta_exonerada = ?,\n" +
                "isc = ?,\n" +
                "cod_isc = ?,\n" +
                "igv = ?,\n" +
                "cod_igv = ?,\n" +
                "otros_tributos = ?,\n" +
                "total = ?,\n" +
                "id_estado = ?,\n" +
                "id_resumen = ?\n" +
                "WHERE serie = ? AND numero = ?;";

        try(PreparedStatement pst = conexion.prepareStatement(sql)){
            pst.setString(1,registro.getTipoDocumento());
            pst.setString(2,registro.getFechaEmision());
            pst.setString(3,registro.getFechaVencimiento());
            pst.setString(4,registro.getTipoCliente());
            pst.setString(5,registro.getNumeroCliente());
            pst.setString(6,registro.getNombreCliente());
            pst.setString(7,registro.getDireccion());
            pst.setString(8,registro.getDistrito());
            pst.setString(9,registro.getProvincia());
            pst.setString(10,registro.getDepartamento());
            pst.setString(11,registro.getEmail());
            pst.setDouble(12,registro.getVentaAfecta());
            pst.setDouble(13,registro.getVentaInafecta());
            pst.setDouble(14,registro.getVentaExonerada());
            pst.setDouble(15,registro.getIsc());
            pst.setString(16,registro.getCodIsc());
            pst.setDouble(17,registro.getIgv());
            pst.setString(18,registro.getCodIgv());
            pst.setDouble(19,registro.getOtrosTributos());
            pst.setDouble(20,registro.getTotal());
            pst.setInt(21,registro.getEstado());
            pst.setInt(22,registro.getResumen());

            pst.setString(23,registro.getSerie());
            pst.setInt(24,registro.getNumero());

            retorno = pst.executeUpdate();
        }
        catch (SQLException e ){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    private BeanDocumento resultSetToBean(ResultSet rs) throws SQLException{
        BeanDocumento documento = new BeanDocumento();
        documento.setSerie(rs.getString("serie"));
        documento.setNumero(rs.getInt("numero"));
        documento.setTipoDocumento(rs.getString("tipo_doc"));
        documento.setFechaEmision(rs.getString("fecha_emision"));
        documento.setFechaVencimiento(rs.getString("fecha_vencimiento"));
        documento.setTipoCliente(rs.getString("tipo_cliente"));
        documento.setNumeroCliente(rs.getString("num_cliente"));
        documento.setNombreCliente(rs.getString("nom_cliente"));
        documento.setDireccion(rs.getString("direccion"));
        documento.setDistrito(rs.getString("distrito"));
        documento.setProvincia(rs.getString("provincia"));
        documento.setDepartamento(rs.getString("departamento"));
        documento.setEmail(rs.getString("email"));
        documento.setVentaAfecta(rs.getDouble("venta_afecta"));
        documento.setVentaInafecta(rs.getDouble("venta_inafecta"));
        documento.setVentaExonerada(rs.getDouble("venta_exonerada"));
        documento.setIsc(rs.getDouble("isc"));
        documento.setCodIsc(rs.getString("cod_isc"));
        documento.setIgv(rs.getDouble("igv"));
        documento.setCodIgv(rs.getString("cod_igv"));
        documento.setOtrosTributos(rs.getDouble("otros_tributos"));
        documento.setTotal(rs.getDouble("total"));
        documento.setEstado(rs.getInt("id_estado"));
        documento.setResumen(rs.getInt("id_resumen"));

        return documento;
    }

    private String convertirParametros( String sql , List<Parametro> parametros){
        StringBuilder query = new StringBuilder(sql);
        query.append( " WHERE ");
        parametros.forEach(p -> query.append(String.format(" %s = ? AND ",p.getField())));
        return query.delete(query.lastIndexOf("AND "),query.length()).toString();
    }
}
