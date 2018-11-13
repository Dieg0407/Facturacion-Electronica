package com.amd.caronte.modelo.dao.facturacion;

import com.amd.caronte.modelo.dao.Parametro;

import java.util.List;

public interface DaoFacturacion<T> {

    T obtenerElemento(Parametro parametro);

    List<T> listarRegistros(List<Parametro> parametros);

    int borrarRegistros(List<Parametro> parametros);

    int actualizarRegistro(T registro);

}
