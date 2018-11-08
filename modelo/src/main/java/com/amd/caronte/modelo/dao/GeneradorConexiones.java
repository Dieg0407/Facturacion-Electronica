package com.amd.caronte.modelo.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Driver;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneradorConexiones {

    public static final int CARONTE = 1;
    public static final int ORIGEN = 2;

    private ParametrosConexion caronte;
    private ParametrosConexion origen;
    private static GeneradorConexiones generador = null;

    private GeneradorConexiones(){

    }

    public static GeneradorConexiones getInstance(){
        if(GeneradorConexiones.generador == null)
            GeneradorConexiones.generador = new GeneradorConexiones();
        return GeneradorConexiones.generador;
    }

    public Connection obtenerConexion(int tipo){

        Connection conexion = null;

        try{
            if(tipo == GeneradorConexiones.CARONTE)
                conexion = this.generarConexion(this.caronte);

            else if(tipo == GeneradorConexiones.ORIGEN)
                conexion = this.generarConexion(this.origen);

        }
        catch (SQLException | NamingException e){
            e.printStackTrace(System.err);
        }
        return conexion;
    }

    private Connection generarConexion(ParametrosConexion parametros) throws SQLException, NamingException {
        Connection conexion = null;
        if(parametros.getTipo().equals("server"))
            conexion = ((DataSource)new InitialContext().lookup(parametros.getJndi())).getConnection();

        else {
            switch(parametros.getDbProvider()) {
                case "postgres":
                    //DriverManager.registerDriver(new org.postgresql.Driver());
                    conexion = DriverManager.getConnection(
                                String.format("jdbc:postgresql://%s:%s/%s",
                                    parametros.getIp(),
                                    parametros.getPort(),
                                    parametros.getDb()) ,
                                    parametros.getUser(),
                                    parametros.getPass());
                    break;
                case "mysql":
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conexion = DriverManager.getConnection(
                                String.format("jdbc:mysql://%s:%s/%s",
                                    parametros.getIp(),
                                    parametros.getPort(),
                                    parametros.getDb()) ,
                                    parametros.getUser(),
                                    parametros.getPass());
                default:
                    throw new IllegalArgumentException ("El proveedor de BD no "
                            + "es soportado por el sistema");
            }
        }
        return conexion;
    }

    private void cargarParametrosCaronte() throws IOException {
        this.caronte = new ParametrosConexion();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStreamReader in = new InputStreamReader(classLoader.getResourceAsStream("db-config.json"));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(in);
        in.close();

        this.caronte.setTipo(root.get("type-connection").textValue());

        JsonNode serverConn = root.get("server-connection");
        this.caronte.setJndi(serverConn.get("jndi").textValue());

        JsonNode programConn = root.get("program-connection");
        this.caronte.setUser(programConn.get("user").textValue());
        this.caronte.setPass(programConn.get("pass").textValue());
        this.caronte.setIp(programConn.get("ip").textValue());
        this.caronte.setPort(programConn.get("port").textValue());
        this.caronte.setDb(programConn.get("db").textValue());
        this.caronte.setDbProvider(programConn.get("db-provider").textValue());

    }

    private void cargarParmetrosOrigen() throws IOException {
        this.origen = new ParametrosConexion();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStreamReader in = new InputStreamReader(classLoader.getResourceAsStream("origen-config.json"));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(in);
        in.close();

        this.origen.setTipo(root.get("type-connection").textValue());

        JsonNode serverConn = root.get("server-connection");
        this.origen.setJndi(serverConn.get("jndi").textValue());

        JsonNode programConn = root.get("program-connection");
        this.origen.setUser(programConn.get("user").textValue());
        this.origen.setPass(programConn.get("pass").textValue());
        this.origen.setIp(programConn.get("ip").textValue());
        this.origen.setPort(programConn.get("port").textValue());
        this.origen.setDb(programConn.get("db").textValue());
        this.origen.setDbProvider(programConn.get("db-provider").textValue());
    }
}
