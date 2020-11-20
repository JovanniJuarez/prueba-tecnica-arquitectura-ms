package com.example.demo.prueba.tecnica.model.request.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestSaveClientFeign {

	private String name;
    private String apellido;
    private String fechaDeNacimiento;
    private String sexo;
}
