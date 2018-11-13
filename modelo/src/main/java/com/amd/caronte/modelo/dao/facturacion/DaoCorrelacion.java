package com.amd.caronte.modelo.dao.facturacion;

import com.amd.caronte.modelo.dao.Parametro;
import com.amd.caronte.modelo.dao.beans.BeanCorrelacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCorrelacion implements DaoFacturacion<BeanCorrelacion> {
    private Connection conexion;

    DaoCorrelacion(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public BeanCorrelacion obtenerElemento(Parametro parametro) {
        BeanCorrelacion correlacion = null;
        String sql = String.format("SELECT * FROM correlacion WHERE %s = ?",parametro.getField());

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setObject(1,parametro.getValor(),parametro.getTipo());
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next())
                    correlacion = this.resultSetToBean(rs);
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            correlacion = null;
        }

        return correlacion;
    }

    @Override
    public List<BeanCorrelacion> listarRegistros(List<Parametro> parametros) {
        List<BeanCorrelacion> correlaciones;
        String sql = "SELECT * FROM correlacion ";
        if(parametros.size() != 0)
            sql = this.convertirParametros(sql,parametros);

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            int i = 1;
            for(Parametro p : parametros)
                pst.setObject(i++,p.getValor(),p.getTipo());

            try(ResultSet rs = pst.executeQuery()){
                correlaciones = new ArrayList<>();
                while(rs.next())
                    correlaciones.add(this.resultSetToBean(rs));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            correlaciones = null;
        }
        return correlaciones;
    }

    @Override
    public int borrarRegistros(List<Parametro> parametros) {
        int retorno = -1;

        String sql = "DELETE FROM correlacion ";
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
    public int actualizarRegistro(BeanCorrelacion registro) {
        int retorno = -1;
        String sql = "UPDATE facturacion_electronica.correlacion\n" +
                "SET\n" +
                "correlativo = ?\n" +
                "WHERE tipo_doc = ? and identificador = ?;";

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setInt(1,registro.getCorrelativo());
            pst.setString(2,registro.getTipoDocumento());
            pst.setString(3,registro.getIdentificador());

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

    private BeanCorrelacion resultSetToBean(ResultSet rs) throws SQLException {

        BeanCorrelacion correlacion = new BeanCorrelacion();
        correlacion.setTipoDocumento(rs.getString("tipo_doc"));
        correlacion.setIdentificador(rs.getString("identificador"));
        correlacion.setCorrelativo(rs.getInt("correlativo"));
        return correlacion;
    }
}
