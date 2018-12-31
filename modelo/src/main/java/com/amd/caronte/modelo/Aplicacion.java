package com.amd.caronte.modelo;

import com.azoth.eve.conexion.GeneradorConexiones;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion implements Runnable{

    public static void  main(String[] args) {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try(InputStream archivoOrigen = classLoader.getResourceAsStream("db-origen.json");
            InputStream archivoFacturacion = classLoader.getResourceAsStream("db-facturacion.json")){

            origen = new GeneradorConexiones();
            facturacionElectronica = new GeneradorConexiones();

            origen.cargarParametros(archivoOrigen);
            facturacionElectronica.cargarParametros(archivoFacturacion);

            try(Connection conn1 = origen.obtenerConexion();
                Connection conn2 = facturacionElectronica.obtenerConexion()){

                System.out.println("Conexion a las bases de datos establecida...");
            }

            URI baseUri = UriBuilder.fromUri("http://localhost/").port(9995).build();
            ResourceConfig config = new ResourceConfig();

            config.packages("com.amd.caronte.modelo.servicios");
            server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
            server.start();

            System.out.println("Servidor Iniciado....");

            System.out.println();
            System.out.println("Iniciando consola");

            Thread t = new Thread(new Aplicacion());
            t.run();

        }
        catch (IOException e){
            System.err.println("Error en el incio del Servidor...");
            e.printStackTrace(System.err);
            salida();
        }
        catch (SQLException e){
            System.err.println("Error en la Conexion a la BD...");
            e.printStackTrace(System.err);
            salida();
        }

    }


    private static HttpServer server;
    private static GeneradorConexiones origen;
    private static GeneradorConexiones facturacionElectronica;



    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        do {
            entrada = scanner.nextLine();
            if(entrada.contains("salir")){
                salida();
            }
            else if(entrada.contains("?")){
                System.out.println("Comandos soportados en consola....");
                System.out.println("Para ejecutar un comando escriba la palabra entre ''");
                System.out.println("1. Salir de forma Segura: 'salir'");
                System.out.println("2. Iniciar migración automática: 'migracion -o iniciar -t <nro de segundos entre barrida>'");
                System.out.println("3. Detener migración automática: 'migracion -o detener ");

                System.out.println();
                System.out.println();
            }

        }while (!entrada.equals("salir"));
    }

    private static void salida(){
        if(Aplicacion.origen != null)
            Aplicacion.origen.cerrarPoolDeConexiones();

        if(Aplicacion.facturacionElectronica != null)
            Aplicacion.facturacionElectronica.cerrarPoolDeConexiones();

        if(server != null){
            try{
                server.shutdown();
            }
            catch (Exception e){
                System.err.println("Error al apagar el servidor...");
                e.printStackTrace(System.err);
            }
        }

        System.out.println("Se han cerrado las conexiones y el servidor...");

    }
}
