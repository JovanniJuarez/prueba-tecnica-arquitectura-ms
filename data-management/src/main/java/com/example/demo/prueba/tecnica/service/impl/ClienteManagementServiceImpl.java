package com.example.demo.prueba.tecnica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.prueba.tecnica.client.feign.ClientFeignRepository;
import com.example.demo.prueba.tecnica.model.request.RequestSaveCliente;
import com.example.demo.prueba.tecnica.model.request.RequestSaveCuenta;
import com.example.demo.prueba.tecnica.model.request.feign.RequestSaveClientFeign;
import com.example.demo.prueba.tecnica.model.response.feign.Cuentas;
import com.example.demo.prueba.tecnica.model.response.feign.ResponseSaveClientFeign;
import com.example.demo.prueba.tecnica.service.ClienteManagementService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteManagementServiceImpl implements ClienteManagementService{

	
	private ClientFeignRepository clientFeignRepository;
	
	@Autowired
	public ClienteManagementServiceImpl(ClientFeignRepository clientFeignRepository) {
		this.clientFeignRepository = clientFeignRepository;
	}
	
	@Override
	public String saveCliente(RequestSaveCliente request) {
		
		RequestSaveClientFeign requestSaveFeign = RequestSaveClientFeign.builder().name(
				request.getName()).apellido(request.getApellido()).fechaDeNacimiento(
						request.getFechaDeNacimiento()).sexo(request.getSexo()).build();
		log.debug("REQUEST SEND SAVE CLIENT {}", requestSaveFeign.toString());
		
		ResponseSaveClientFeign response = clientFeignRepository.saveCliente(requestSaveFeign);
		log.debug("RESPONSE SAVE CLIENT {}", response.toString());
		
		return "Client ".concat(response.getName()).concat(" saved successfully");
	}

	@Override
	public ResponseSaveClientFeign getClientes() {
		
		ResponseSaveClientFeign response = clientFeignRepository.getClientes();
		log.debug("RESPONSE GET CLIENTES {}", response.toString());
		
		return response;
	}

	@Override
	public ResponseSaveClientFeign getClienteId(Long id) {
		
		ResponseSaveClientFeign response = clientFeignRepository.getCliente(id);
		log.debug("RESPONSE GET CLIENTE {}", response.toString());
		
		return response;
	}

	@Override
	public String updateClient(Long id, RequestSaveCliente request) {
		
		RequestSaveClientFeign requestUpdateFeign = RequestSaveClientFeign.builder().name(
				request.getName()).apellido(request.getApellido()).fechaDeNacimiento(
						request.getFechaDeNacimiento()).sexo(request.getSexo()).build();
		log.debug("REQUEST SEND UPDATE CLIENT {}", requestUpdateFeign.toString());
		
		ResponseSaveClientFeign response = clientFeignRepository.updateCliente(id,
				requestUpdateFeign);
		log.debug("RESPONSE UPDATE CLIENT {}", response.toString());
		
		return "Client ".concat(response.getName()).concat(" update successfully");
		
	}

	@Override
	public String deleteClient(Long id) {
		
		String response = clientFeignRepository.deleteClient(id);
		log.debug("RESPONSE UPDATE CLIENT {}", response.toString());
		return response;
	}

	@Override
	public String saveCuenta(Long clienteId, RequestSaveCuenta request) {
		
		log.debug("REQUEST SEND SAVE CUENTA {}", request.toString());
		
		Cuentas response = clientFeignRepository.saveCuentas(clienteId,
				request);
		log.debug("RESPONSE SAVE CUENTA {}", response.toString());
		
		return "Client ".concat(response.getNumeroCuenta()).concat(" saved successfully");
	}

	@Override
	public Cuentas getCuentas(Long clienteId) {
		
		Cuentas response = clientFeignRepository.getCuentas(clienteId);
		log.debug("RESPONSE GET CUENTAS {}", response);
		return response;
	}

	@Override
	public String updateCuenta(Long clienteId, Long cuentaId, RequestSaveCuenta request) {
		
		Cuentas response = clientFeignRepository.updateCuenta(clienteId, cuentaId, request);
		log.debug("RESPONSE UPDATE CUENTA {}", response);
		return "Cuenta".concat(response.getNumeroCuenta()).concat("update successfully");
	}

	@Override
	public String deleteCuenta(Long clienteId, Long cuentaId) {
		
		String response = clientFeignRepository.deleteCuenta(clienteId, cuentaId);
		return response;
	}

}
