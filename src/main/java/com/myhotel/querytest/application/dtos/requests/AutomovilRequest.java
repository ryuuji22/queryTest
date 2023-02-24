package com.myhotel.querytest.application.dtos.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutomovilRequest extends VehiculoBaseRequest {

    @NotBlank(message = "El campo tipo no puede ser vacío")
    private String tipo;
    @Min(value = 1, message = "El valor para puertas debe ser minimo 1")
    private Integer puertas;
    @Min(value = 1, message = "El valor para pasajeros debe ser minimo 1")
    private Integer pasajeros;

    private Double capacidadMaletero;

}
