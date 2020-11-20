package com.example.demo.prueba.tecnica.model.response.feign;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSaveClientFeign {

	private Long id;
	private String name;
    private String apellido;
    private String fechaDeNacimiento;
    private String sexo;
    private List<Cuentas> cuentas;
}
