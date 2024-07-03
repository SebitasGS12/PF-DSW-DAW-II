package com.skillswap.skillswap_core.constants;

public class Alertas {
    
    public static  final String MensajeRecibido = " te ah enviado un mensaje!";
    public static final String tituloNuevoMensaje = "Nuevo Mensaje";
    
    public static String crearMensajeRecibido(String emisor ){

        return emisor.toUpperCase() + MensajeRecibido;

    }
}
