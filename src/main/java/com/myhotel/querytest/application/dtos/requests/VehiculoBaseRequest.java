package com.myhotel.querytest.application.dtos.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehiculoBaseRequest {

    @NotBlank(message = "El campo marca no puede ser vacío")
    private String marca;
    @NotBlank(message = "El campo modelo no puede ser vacío")
    private String modelo;
    @NotBlank(message = "El campo patente no puede ser vacío")
    private String patente;
    @Min(value = 1950, message = "El valor para anio debe ser minimo 1950")
    private Integer anio;
    private Double kilometraje;
    private Double cilindrada;

}
