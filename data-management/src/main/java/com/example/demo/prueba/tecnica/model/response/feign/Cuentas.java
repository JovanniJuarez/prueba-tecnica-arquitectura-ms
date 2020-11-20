package com.example.demo.prueba.tecnica.model.response.feign;

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
public class Cuentas {

	private Long id;
	private String numeroCuenta;
	private String saldo;
	private String tipoProducto;
}
