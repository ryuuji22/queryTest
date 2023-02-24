package com.myhotel.querytest.application.dtos.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CamionRequest extends VehiculoBaseRequest {

    @NotBlank(message = "El campo tipo no puede ser vacío")
    private String tipo;

    private Double capacidadToneladas;
    @Min(value = 1, message = "El valor para ejes debe ser minimo 1")
    private Integer ejes;

}
