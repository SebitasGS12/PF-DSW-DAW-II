package com.skillswap.skillswap_core.constants;

public enum CodigoError {
    
    BAD_REQUEST(40001,"BAD_REQUEST", "Solicitud inválida"),
    UNAUTHORIZED(40101,"UNAUTHORIZED", "No autorizado"),
    NOT_FOUND(40401,"NOT_FOUND", "Recurso no encontrado"),
    INTERNAL_SERVER_ERROR(50000,"INTERNAL_SERVER_ERROR", "Error interno del servidor");
    
    int codigo;
    String mensaje;
    String detalle;


    private CodigoError(int codigo, String mensaje, String detalle) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }


    public int getCodigo() {
        return codigo;
    }


    public String getMensaje() {
        return mensaje;
    }


    public String getDetalle() {
        return detalle;
    }
    


}
