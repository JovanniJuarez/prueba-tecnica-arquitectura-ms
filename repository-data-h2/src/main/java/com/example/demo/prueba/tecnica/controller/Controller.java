package com.example.demo.prueba.tecnica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prueba.tecnica.entity.Cliente;
import com.example.demo.prueba.tecnica.repository.ClienteRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/get/clientes")
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
    @GetMapping("/clientes/{id}")
    public Cliente getClienteByID(@PathVariable Long id) throws NotFoundException {
    	Optional<Cliente> optCliente = clienteRepository.findById(id);
    	if(optCliente.isPresent()) {
    		return optCliente.get();
    	}else {
    		throw new NotFoundException("Cliente not found with id " + id);
    	}
    }
	
	@PostMapping("/save/cliente")
	public Cliente saveCliente(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	
	@PutMapping("/update/cliente/{id}")
	public Cliente updateCliente(@PathVariable Long id,
			 @RequestBody Cliente clienteToUpdate) throws NotFoundException{
		return clienteRepository.findById(id)
		        .map(cliente -> {
		            cliente.setName(clienteToUpdate.getName());
		            cliente.setApellido(clienteToUpdate.getApellido());
		            cliente.setFechaDeNacimiento(clienteToUpdate.getFechaDeNacimiento());
		            cliente.setSexo(clienteToUpdate.getSexo());
		            return clienteRepository.save(cliente);
		        }).orElseThrow(() -> new NotFoundException("Cliente not found with id " + id));
	}
	
	@DeleteMapping("/delete/cliente/{id}")
	public String deleteCliente(@PathVariable Long id) throws NotFoundException{
		return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Cliente not found with id " + id));
	}

} 
