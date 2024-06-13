package com.skillswap.skillswap_core.constants;

public enum CodigoError {
    
    BAD_REQUEST(40001, "Solicitud inválida"),
    UNAUTHORIZED(40101,"No autorizado"),
    NOT_FOUND(40401,"Recurso no encontrado"),
    INTERNAL_SERVER_ERROR(50000, "Error interno del servidor");
    
    int codigo;
    String mensaje;


    private CodigoError(int codigo, String mensaje ) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }


    public int getCodigo() {
        return codigo;
    }


    public String getMensaje() {
        return mensaje;
    }



}
