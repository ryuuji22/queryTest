/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.querytest.infraestructure.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diego
 */

@Entity
@Table(name = "AUTOMOVILES", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class AutomovilModel extends VehiculoModel {
    
    private String tipo;
    private Integer puertas;
    private Integer pasajeros;
    @Column(name = "capacidad_maletero")
    private Double capacidadMaletero;
    
    
}
