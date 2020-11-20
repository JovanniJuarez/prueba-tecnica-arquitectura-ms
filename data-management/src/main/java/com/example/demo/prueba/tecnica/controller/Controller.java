package com.example.demo.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prueba.tecnica.model.request.RequestSaveCliente;
import com.example.demo.prueba.tecnica.model.request.RequestSaveCuenta;
import com.example.demo.prueba.tecnica.model.response.feign.Cuentas;
import com.example.demo.prueba.tecnica.model.response.feign.ResponseSaveClientFeign;
import com.example.demo.prueba.tecnica.service.ClienteManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class Controller {
	
	@Autowired
	ClienteManagementService clienteManagementService;
	
	@PostMapping("/save/client")
	public ResponseEntity<String> saveCliente(@RequestBody RequestSaveCliente request){
	
		log.info("***** START APPLICATION ******");
		log.debug("REQUEST SEND TO API {}", request.toString());
		String response = clienteManagementService.saveCliente(request);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/clientes")
	public ResponseEntity<ResponseSaveClientFeign> getClientes(){
		
		log.info("***** START APPLICATION *****");
		ResponseSaveClientFeign response = clienteManagementService.getClientes();
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/cliente/{id}")
	public ResponseEntity<ResponseSaveClientFeign> getClienteId(@PathVariable
			Long id){
		
		log.info("***** START APPLICATION *****");
		ResponseSaveClientFeign response = clienteManagementService.getClienteId(id);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/cliente/{id}")
	public ResponseEntity<String> updateCliente(@PathVariable Long id,
			@RequestBody RequestSaveCliente request){
	
		log.info("***** START APPLICATION ******");
		log.debug("REQUEST SEND TO API {}", request.toString());
		String response = clienteManagementService.updateClient(id, request);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/cliente/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id){
	
		log.info("***** START APPLICATION ******");
		String response = clienteManagementService.deleteClient(id);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/save/cliente/{clienteId}/cuentas")
	public ResponseEntity<String> saveCuenta(@PathVariable Long clienteId, 
			@RequestBody RequestSaveCuenta request){
	
		log.info("***** START APPLICATION ******");
		log.debug("REQUEST SEND TO API {}", request.toString());
		String response = clienteManagementService.saveCuenta(clienteId, request);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/cliente/{clienteId}/cuentas")
	public ResponseEntity<Cuentas> getCuentas(@PathVariable Long clienteId){
		
		log.info("***** START APPLICATION *****");
		Cuentas response = clienteManagementService.getCuentas(clienteId);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update/cliente/{clienteId}/cuenta/{cuentaId}")
	public String updateCuenta(@PathVariable Long clienteId, @PathVariable Long cuentaId,
			RequestSaveCuenta request) {
		
		log.info("***** START APPLICATION *****");
		String response = clienteManagementService.updateCuenta(clienteId, cuentaId, request);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return response;
	}
	
	@DeleteMapping("delete/clientes/{clienteId}/cuentas/{cuentaId}")
	public ResponseEntity<String> deleteCuenta(@PathVariable Long clienteId,
			@PathVariable Long cuentaId){
	
		log.info("***** START APPLICATION ******");
		String response = clienteManagementService.deleteCuenta(clienteId, cuentaId);
		log.debug("RESPONSE API {}", response.toString());
		log.info("***** FINISH APPLICATION ******");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
