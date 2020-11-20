package com.example.demo.prueba.tecnica.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.prueba.tecnica.model.request.RequestSaveCuenta;
import com.example.demo.prueba.tecnica.model.request.feign.RequestSaveClientFeign;
import com.example.demo.prueba.tecnica.model.response.feign.Cuentas;
import com.example.demo.prueba.tecnica.model.response.feign.ResponseSaveClientFeign;

@FeignClient(value = "REPOSITORY-DATA")
public interface ClientFeignRepository {

	@PostMapping(value = "/api/v1/save/cliente")
	ResponseSaveClientFeign saveCliente(RequestSaveClientFeign request);
	
	@GetMapping(value = "/api/v1/get/clientes")
	ResponseSaveClientFeign getClientes();
	
	@GetMapping(value = "/api/v1/clientes/{id}")
	ResponseSaveClientFeign getCliente(@PathVariable("id") Long id);
	
	@PutMapping(value = "/api/v1/update/cliente/{id}")
	ResponseSaveClientFeign updateCliente(@PathVariable("id") Long id, RequestSaveClientFeign request);
	
	@DeleteMapping(value = "/api/v1/delete/cliente/{id}")
	String deleteClient(@PathVariable("id") Long id);
	
	@PostMapping(value = "/api/v1/clientes/{clienteId}/cuentas")
	Cuentas saveCuentas(@PathVariable("clienteId") Long clienteId, RequestSaveCuenta request);
	
	@GetMapping(value = "/api/v1/clientes/{clienteId}/cuentas")
	Cuentas getCuentas(@PathVariable("clienteId") Long clienteId);
	
	@PutMapping(value = "/api/v1/clientes/{clienteId}/cuentas/{cuentaId}")
	Cuentas updateCuenta(@PathVariable("clienteId") Long clienteId, @PathVariable("cuentaId")
			Long cuentaId, RequestSaveCuenta request);
	
	@DeleteMapping(value = "api/v1/clientes/{clienteId}/cuentas/{cuentaId}")
	String deleteCuenta(@PathVariable("clienteId") Long clienteId, @PathVariable("cuentaId")
			Long cuentaId);
}
