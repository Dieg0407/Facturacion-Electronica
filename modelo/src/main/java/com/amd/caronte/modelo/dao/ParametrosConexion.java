package com.amd.caronte.modelo.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;

class ParametrosConexion {
   private String tipo;

   private String jndi;

   private String ip;
   private String port;
   private String user;
   private String pass;
   private String db;
   private String dbProvider;

   ParametrosConexion() throws IOException{

       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       InputStreamReader in = new InputStreamReader(classLoader.getResourceAsStream("db-config.json"));

       ObjectMapper mapper = new ObjectMapper();
       JsonNode root = mapper.readTree(in);
       in.close();

       this.tipo = root.get("type-connection").textValue();

       JsonNode serverConn = root.get("server-connection");
       this.jndi = serverConn.get("jndi").textValue();

       JsonNode programConn = root.get("program-connection");
       this.user 	= programConn.get("user").textValue();
       this.pass 	= programConn.get("pass").textValue();
       this.ip   	= programConn.get("ip").textValue();
       this.port	= programConn.get("port").textValue();
       this.db		= programConn.get("db").textValue();
       this.dbProvider = programConn.get("db-provider").textValue();

   }


   String getDbProvider() {
       return dbProvider;
   }

   String getTipo() {
       return tipo;
   }

   String getJndi() {
       return jndi;
   }

   String getIp() {
       return ip;
   }

   String getPort() {
       return port;
   }

   String getUser() {
       return user;
   }

   String getPass() {
       return pass;
   }

   String getDb() {
       return db;
   }

    void setTipo(String tipo) {
        this.tipo = tipo;
    }

    void setJndi(String jndi) {
        this.jndi = jndi;
    }

    void setIp(String ip) {
        this.ip = ip;
    }

    void setPort(String port) {
        this.port = port;
    }

    void setUser(String user) {
        this.user = user;
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    void setDb(String db) {
        this.db = db;
    }

    void setDbProvider(String dbProvider) {
        this.dbProvider = dbProvider;
    }
}
