package com.amd.caronte.modelo.dao.origen;

import com.amd.caronte.modelo.dao.beans.BeanDetalle;
import com.amd.caronte.modelo.dao.beans.BeanDocumento;

import java.util.List;
import java.util.Map;

public interface DaoOrigen{


    List<BeanDocumento> obtenerDocumentos(String fecha, Map<String,Integer[]> registros);

    List<BeanDetalle> obtenerDetalles(List<BeanDocumento> documentos);

}
