package com.example.demo.prueba.tecnica.model.request;

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
public class RequestSaveCliente {
	
	private String name;
    private String apellido;
    private String fechaDeNacimiento;
    private String sexo;
}
