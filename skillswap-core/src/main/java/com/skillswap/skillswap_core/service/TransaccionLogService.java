package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.TransaccionLog;
import com.skillswap.skillswap_core.repository.ITransaccionLogRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransaccionLogService {
    private final ITransaccionLogRepository retralog;

    public int ultimoId(){
        List<TransaccionLog> lista = retralog.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getTransaccionLogId()+1 ;
    }

    public List<TransaccionLog> findAll(){
        return retralog.findAll();
    }
    public TransaccionLog findById(int id){
        return  retralog.findById(id).orElseThrow();
    }

    public void saveTransaccionLog(TransaccionLog transaccionLog) {
        if (transaccionLog.getTransaccionLogId() == null ){
            transaccionLog.setTransaccionLogId(ultimoId());
        }
        retralog.save(transaccionLog);
    }
    public void delteTransaccionLogById(Integer id) {
        retralog.deleteById(id);
    }
    public TransaccionLog nullTransaccionLog() {
        TransaccionLog transaccionLog = new TransaccionLog();
        transaccionLog.setTransaccionLogId(null);
        return transaccionLog;
    }
    public TransaccionLog newTransaccionLog() {
        TransaccionLog transaccionLog = new TransaccionLog();
        transaccionLog.setTransaccionLogId(ultimoId());
        return transaccionLog;
    }
}
