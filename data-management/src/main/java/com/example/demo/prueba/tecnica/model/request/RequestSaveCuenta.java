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
public class RequestSaveCuenta {

	private String numeroCuenta;
	private String saldo;
	private String tipoProducto;
}
