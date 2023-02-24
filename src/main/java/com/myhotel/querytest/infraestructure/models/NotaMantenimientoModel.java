/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.querytest.infraestructure.models;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diego
 */

@Entity
@Table(name = "NOTASMANTENIMIENTO", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class NotaMantenimientoModel  {
    @Id
    private String id;
    private String resumen;
    private LocalDate fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehiculo_id", nullable=false)
    private VehiculoModel vehiculo;
    
    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
    
    
}
