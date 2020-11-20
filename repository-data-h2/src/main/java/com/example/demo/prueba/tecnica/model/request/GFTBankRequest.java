package com.example.demo.prueba.tecnica.model.request;

import com.example.demo.prueba.tecnica.entity.Cliente;

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
public class GFTBankRequest {
	
	private Cliente cliente;
}
