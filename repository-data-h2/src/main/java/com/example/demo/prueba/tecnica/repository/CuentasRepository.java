package com.example.demo.prueba.tecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.prueba.tecnica.entity.Cuentas;

@Repository
public interface CuentasRepository extends JpaRepository<Cuentas, Long>{
	List<Cuentas> findByClienteId(Long clienteId);

}
