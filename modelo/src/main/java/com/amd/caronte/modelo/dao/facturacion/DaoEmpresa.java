package com.amd.caronte.modelo.dao.facturacion;

import com.amd.caronte.modelo.dao.Parametro;
import com.amd.caronte.modelo.dao.beans.BeanEmpresa;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoEmpresa implements DaoFacturacion <BeanEmpresa> {
    private Connection conexion;

    DaoEmpresa(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public BeanEmpresa obtenerElemento(Parametro parametro) {
        BeanEmpresa empresa = null;
        String sql = String.format("SELECT * FROM empresa WHERE %s = ?",parametro.getField());

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setObject(1,parametro.getValor(),parametro.getTipo());
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next())
                    empresa = this.resultSetToBean(rs);
            }
            empresa.setTelefonos(this.obtenerTelefonos(empresa.getRuc()));
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
            empresa = null;
        }

        return empresa;
    }

    @Override
    public List<BeanEmpresa> listarRegistros(List<Parametro> parametros) {
        throw new UnsupportedOperationException("No puede haber mas de una empresa");
    }

    @Override
    public int borrarRegistros(List<Parametro> parametros) {
        int retorno = -1;

        String sql = "DELETE FROM empresa ";
        if(parametros.size() != 0){
            sql = this.convertirParametros(sql,parametros);
            try(Statement st = this.conexion.createStatement()) {
                st.execute("delete from telefonos");
                try(PreparedStatement pst = this.conexion.prepareStatement(sql)){

                    int i = 1;
                    for(Parametro p : parametros)
                        pst.setObject(i++,p.getValor(),p.getTipo());
                    retorno = pst.executeUpdate();
                }
            }
            catch (SQLException e){
                e.printStackTrace(System.err);
            }
        }

        return retorno;
    }

    @Override
    public int actualizarRegistro(BeanEmpresa registro) {
        int retorno = -1;
        String sql = "UPDATE empresa\n" +
                "SET\n" +
                "ruc = ?,\n" +
                "nombre = ?,\n" +
                "nombre_comercial = ?,\n" +
                "ubigeo = ?,\n" +
                "direccion = ?,\n" +
                "urbanizacion = ?,\n" +
                "distrito = ?,\n" +
                "provincia = ?,\n" +
                "certificado = ?,\n" +
                "nom_certificado = ?,\n" +
                "pin = ?,\n" +
                "alias = ?,\n" +
                "usuario_secundario = ?,\n" +
                "pass = ?,\n" +
                "email = ?,\n" +
                "web = ?\n" +
                "WHERE ruc = ?;";

        try(PreparedStatement pst = this.conexion.prepareStatement(sql)){
            pst.setString(1,registro.getRuc());
            pst.setString(2,registro.getNombre());
            pst.setString(3,registro.getNombreComercial());
            pst.setString(4,registro.getUbigeo());
            pst.setString(5,registro.getDireccion());
            pst.setString(6,registro.getUrbanizacion());
            pst.setString(7,registro.getDistrito());
            pst.setString(8,registro.getProvincia());
            pst.setBytes(9,registro.getCertificado());
            pst.setString(10,registro.getNombreCertificado());
            pst.setString(11,registro.getPin());
            pst.setString(12,registro.getAlias());
            pst.setString(13,registro.getUsuarioSecundario());
            pst.setString(14,registro.getPassword());
            pst.setString(15,registro.getEmail());
            pst.setString(16,registro.getWeb());
            pst.setString(17,registro.getRuc());
            retorno = pst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return retorno;
    }
    private List<String> obtenerTelefonos(String ruc){
        List<String> telefonos = new ArrayList<>();
        try(Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from telefonos WHERE ruc = ? ")){

            while(rs.next())
                telefonos.add(rs.getString("numero"));

        }catch (SQLException e){
            e.printStackTrace(System.err);
        }

        return telefonos;
    }

    private void actualizarTelefonos(List<String> telefonos, String ruc) {
        try(PreparedStatement pst = this.conexion.prepareStatement("delete * from telefonos WHERE ruc = ? ")){
            pst.setString(1,ruc);
            pst.executeUpdate();

            try(PreparedStatement pst2 = this.conexion.prepareStatement("insert into telefonos (ruc, numero) VALUES (?,?) ")){

                for(String telefono : telefonos) {
                    pst2.setString(1, ruc);
                    pst2.setString(2, telefono);
                    pst2.executeUpdate();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
    }

    private String convertirParametros( String sql , List<Parametro> parametros){
        StringBuilder query = new StringBuilder(sql);
        query.append( " WHERE ");
        parametros.forEach(p -> query.append(String.format(" %s = ? AND ",p.getField())));
        return query.delete(query.lastIndexOf("AND "),query.length()).toString();
    }

    private BeanEmpresa resultSetToBean(ResultSet rs) throws SQLException {

        BeanEmpresa empresa = new BeanEmpresa();
        empresa.setRuc(rs.getString("ruc"));
        empresa.setNombre(rs.getString("nombre"));
        empresa.setNombreComercial(rs.getString("nombre_comercial"));
        empresa.setUbigeo(rs.getString("ubigeo"));
        empresa.setDireccion(rs.getString("direccion"));
        empresa.setUrbanizacion(rs.getString("urbanizacion"));
        empresa.setDistrito(rs.getString("distrito"));
        empresa.setProvincia(rs.getString("provincia"));
        empresa.setCertificado(rs.getBytes("certificado"));
        empresa.setNombreCertificado(rs.getString("nom_certificado"));
        empresa.setPin(rs.getString("pin"));
        empresa.setAlias(rs.getString("alias"));
        empresa.setUsuarioSecundario(rs.getString("usuario_secundario"));
        empresa.setPassword(rs.getString("pass"));
        empresa.setEmail(rs.getString("email"));
        empresa.setWeb(rs.getString("web"));



        return empresa;
    }
}
