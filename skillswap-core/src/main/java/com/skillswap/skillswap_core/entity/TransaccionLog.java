package com.skillswap.skillswap_core.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaccionLog")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransaccionLog {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer transaccionLogId;
    private String descripcion;
    private Date fechaCreacion;
    
    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario obj_Usuario;


}
