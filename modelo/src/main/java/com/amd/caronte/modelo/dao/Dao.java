package com.amd.caronte.modelo.dao;

public interface Dao <T>{

    /**
     * Obtienes una instancia del Bean 'T'
     * @return una nueva instancia
     */
    T getInstance();


}
