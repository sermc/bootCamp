package com.nttdata.servicioRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.servicioRest.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByNombreAndApellidosIgnoreCaseLike(String nombre, String apellidos);
	List<Cliente> findByNombreIgnoreCaseLike(String nombre);
}
