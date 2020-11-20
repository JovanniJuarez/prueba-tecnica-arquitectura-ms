package com.example.demo.prueba.tecnica.service;

import com.example.demo.prueba.tecnica.model.request.RequestSaveCliente;
import com.example.demo.prueba.tecnica.model.request.RequestSaveCuenta;
import com.example.demo.prueba.tecnica.model.response.feign.Cuentas;
import com.example.demo.prueba.tecnica.model.response.feign.ResponseSaveClientFeign;

public interface ClienteManagementService {
	
	String saveCliente(RequestSaveCliente request);
	
	ResponseSaveClientFeign getClientes();
	
	ResponseSaveClientFeign getClienteId(Long id);
	
	String updateClient(Long id, RequestSaveCliente request);
	
	String deleteClient(Long id);
	
	String saveCuenta(Long clienteId, RequestSaveCuenta request);
	
	Cuentas getCuentas(Long clienteId);
	
	String updateCuenta(Long clienteId, Long cuentaId, RequestSaveCuenta request);
	
	String deleteCuenta(Long clienteId, Long cuentaId);
	
}
