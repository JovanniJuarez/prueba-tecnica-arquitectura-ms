package com.example.demo.prueba.tecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prueba.tecnica.entity.Cuentas;
import com.example.demo.prueba.tecnica.repository.ClienteRepository;
import com.example.demo.prueba.tecnica.repository.CuentasRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1")
public class ControllerCuentas {
	
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CuentasRepository cuentasRepository;
	
	@GetMapping("/clientes/{clienteId}/cuentas")
	public List<Cuentas> getCuentaByClienteId(@PathVariable Long clienteId) throws NotFoundException {
		if(!clienteRepository.existsById(clienteId)) {
            throw new NotFoundException("Cliente not found!");
        }
    	return cuentasRepository.findByClienteId(clienteId);
    }
	
	@PostMapping("/clientes/{clienteId}/cuentas")
	public Cuentas saveCuenta(@PathVariable Long clienteId,
            @RequestBody Cuentas cuentas) throws NotFoundException{
		return clienteRepository.findById(clienteId)
                .map(cliente -> {
                    cuentas.setCliente(cliente);
                    return cuentasRepository.save(cuentas);
                }).orElseThrow(() -> new NotFoundException("Cliente not found!"));
	}
	
	@PutMapping("/clientes/{clienteId}/cuentas/{cuentaId}")
	public Cuentas updateCuentas(@PathVariable Long clienteId,
			@PathVariable Long cuentaId, @RequestBody Cuentas cuentasToUpdate) throws NotFoundException{
		return cuentasRepository.findById(cuentaId)
                .map(cuentas -> {
                	cuentas.setNumeroCuenta(cuentasToUpdate.getNumeroCuenta());
                    cuentas.setSaldo(cuentasToUpdate.getSaldo());
                    cuentas.setTipoProducto(cuentasToUpdate.getTipoProducto());
                    return cuentasRepository.save(cuentas);
                }).orElseThrow(() -> new NotFoundException("Cuentas not found!"));
	}
	
	@DeleteMapping("/clientes/{clienteId}/cuentas/{cuentaId}")
	public String deleteCuenta(@PathVariable Long clienteId, 
			@PathVariable Long cuentaId) throws NotFoundException{
		if(!clienteRepository.existsById(clienteId)) {
    		throw new NotFoundException("Cliente not found!");
    	}
		return cuentasRepository.findById(cuentaId)
                .map(cuentas -> {
                    cuentasRepository.delete(cuentas);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Cuentas not found!"));
	}
}
