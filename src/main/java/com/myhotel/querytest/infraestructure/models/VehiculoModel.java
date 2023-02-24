/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.querytest.infraestructure.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
@Table(name = "VEHICULOS", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class VehiculoModel {

    @Id
    private String id;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
    private Double kilometraje;
    private Double cilindrada;
    
    @OneToMany(mappedBy="vehiculo", cascade=CascadeType.ALL)
    private List<NotaMantenimientoModel> notasMantenimiento;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }

}
