package com.skillswap.skillswap_core.exceptions;

import com.skillswap.skillswap_core.constants.CodigoError;

public class ErrorResponse {

    private int codigo;
    private String mensaje;
    private String detalle;
    
    public ErrorResponse(int codigo, String mensaje, String detalle) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

}
