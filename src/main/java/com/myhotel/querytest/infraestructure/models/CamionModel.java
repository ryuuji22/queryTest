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
@Table(name = "CAMIONES", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class CamionModel extends VehiculoModel {

    private String tipo;
    @Column(name = "capacidad_toneladas")
    private Double capacidadToneladas;
    private Integer ejes;
}
