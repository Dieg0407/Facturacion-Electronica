package com.amd.caronte.modelo.generadores.xml;

public interface Xml {

    /**
     * Este método genera el 'xml' firmado y lo almacena en un arreglo de
     * bytes.
     * @return un arreglo de bytes con el archivo firmado
     */
    byte[] generarArchivo();
}