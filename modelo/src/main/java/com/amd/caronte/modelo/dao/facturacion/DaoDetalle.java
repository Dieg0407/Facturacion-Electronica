package com.amd.caronte.modelo.dao.facturacion;

import com.amd.caronte.modelo.dao.Parametro;
import com.amd.caronte.modelo.dao.beans.BeanDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDetalle implements  DaoFacturacion<BeanDetalle> {

    private Connection conexion;

    DaoDetalle (Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public BeanDetalle obtenerElemento(Parametro parametro) {
        BeanDetalle detalle = null;
        String sql = String.format("SELECT * FROM detalles WHERE %s = ?",parametro.getField());

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setObject(1,parametro.getValor(),parametro.getTipo());
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next())
                    detalle = this.resultSetToBean(rs);
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            detalle = null;
        }

        return detalle;
    }

    @Override
    public List<BeanDetalle> listarRegistros(List<Parametro> parametros) {
        List<BeanDetalle> detalles;
        String sql = "SELECT * FROM detalles ";
        if(parametros.size() != 0)
            sql = this.convertirParametros(sql,parametros);

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            int i = 1;
            for(Parametro p : parametros)
                pst.setObject(i++,p.getValor(),p.getTipo());

            try(ResultSet rs = pst.executeQuery()){
                detalles = new ArrayList<>();
                while(rs.next())
                    detalles.add(this.resultSetToBean(rs));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            detalles = null;
        }
        return detalles;
    }

    @Override
    public int borrarRegistros(List<Parametro> parametros) {
        int retorno = -1;

        String sql = "DELETE FROM detalles ";
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
    public int actualizarRegistro(BeanDetalle registro) {
        int retorno = -1;
        String sql = "UPDATE detalles\n" +
                "SET\n" +
                "codigo = ?,\n" +
                "descripcion = ?,\n" +
                "unidad = ?,\n" +
                "valor_unitario = ?,\n" +
                "cantidad = ?,\n" +
                "isc = ?,\n" +
                "cod_isc = ?,\n" +
                "igv = ?,\n" +
                "cod_igv = ?,\n" +
                "otros_tributos = ?,\n" +
                "total = ?\n" +
                "WHERE sec = ? AND serie = ? AND numero = ?;";

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setString(1,registro.getCodigo());
            pst.setString(2,registro.getDescripcion());
            pst.setString(3,registro.getUnidad());
            pst.setDouble(4,registro.getValorUnitario());
            pst.setDouble(5,registro.getCantidad());
            pst.setDouble(6,registro.getIsc());
            pst.setString(7,registro.getCodIsc());
            pst.setDouble(8,registro.getIgv());
            pst.setString(9,registro.getCodIgv());
            pst.setDouble(10,registro.getOtrosTributos());
            pst.setDouble(11,registro.getTotal());

            pst.setInt(12,registro.getSec());
            pst.setString(13,registro.getSerie());
            pst.setInt(14,registro.getNumero());

            retorno = pst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }

    private String convertirParametros( String sql , List<Parametro> parametros){
        StringBuilder query = new StringBuilder(sql);
        query.append( " WHERE ");
        parametros.forEach(p -> query.append(String.format(" %s = ? AND ",p.getField())));
        return query.delete(query.lastIndexOf("AND "),query.length()).toString();
    }

    private BeanDetalle resultSetToBean(ResultSet rs) throws SQLException {

        BeanDetalle detalle = new BeanDetalle();
        detalle.setSerie(rs.getString("serie"));
        detalle.setNumero(rs.getInt("numero"));
        detalle.setSec(rs.getInt("sec"));
        detalle.setCodigo(rs.getString("codigo"));
        detalle.setDescripcion(rs.getString("descripcion"));
        detalle.setUnidad(rs.getString("unidad"));
        detalle.setValorUnitario(rs.getDouble("valor_unitario"));
        detalle.setCantidad(rs.getDouble("cantidad"));
        detalle.setIsc(rs.getDouble("isc"));
        detalle.setCodIsc(rs.getString("cod_isc"));
        detalle.setIgv(rs.getDouble("igv"));
        detalle.setCodIgv(rs.getString("cod_igv"));
        detalle.setOtrosTributos(rs.getDouble("otros_tributos"));
        detalle.setTotal(rs.getDouble("total"));

        return detalle;
    }

}
