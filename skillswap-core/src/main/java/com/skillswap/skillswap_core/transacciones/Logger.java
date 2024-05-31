package com.skillswap.skillswap_core.transacciones;

import com.skillswap.skillswap_core.entity.Sesion;
import com.skillswap.skillswap_core.entity.TransaccionLog;
import com.skillswap.skillswap_core.service.SesionService;
import com.skillswap.skillswap_core.service.TransaccionLogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class Logger {

    private final TransaccionLogService  transaccionLogService;
    private final SesionService sesionService;
    private String NombreClase = "";

    public static Logger getLogger(Class<?> T ){
        Logger logger = new Logger(null,null);
        logger.NombreClase = T.getName();
        return logger;
    }
    private void enviarLog(String msg){
        Sesion sesion = sesionService.getSesion();

        transaccionLogService.saveTransaccionLog(
                TransaccionLog.builder()
                        .fechaCreacion(new Date())
                        .descripcion(msg)
                        .obj_Usuario(sesion.getObj_Usuario())
                        .build()
        );
    }
    public  void error(String msg){
        enviarLog("B "+msg+" At:"+NombreClase);
    }

    public  void info(String msg ){
        enviarLog("T "+msg+" At:"+NombreClase);
    }

    public void transaccion(String msg ){
        enviarLog("X "+msg+" At:"+NombreClase);
    }


}
