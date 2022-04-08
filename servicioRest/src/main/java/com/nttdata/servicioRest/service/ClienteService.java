package com.nttdata.servicioRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.servicioRest.entity.Cliente;
import com.nttdata.servicioRest.repository.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repositorio;
	
	public Cliente insert (Cliente c) {
		return repositorio.save(c);
	}
	
	public String delete (Long c) {
		if(repositorio.findById(c).isPresent()) {
			repositorio.deleteById(c);
			return "Cliente eliminado con éxito";
		}
		return "No se ha podido eliminar al cliente";
	}
	
	public void update (Cliente c) {
		long num = c.getId();
		
		if(repositorio.findById(num).isPresent()) {
			Cliente clieToUpdate = repositorio.getById(num);
			
			if(c.getNombre() != null) {
				clieToUpdate.setNombre(c.getNombre());
			}
			
			if(c.getApellidos() != null) {
				clieToUpdate.setApellidos(c.getApellidos());
			}
			
			if(c.getFechaNacimiento() != null) {
				clieToUpdate.setFechaNacimiento(c.getFechaNacimiento());
			}
			
			if(c.getDni() != null) {
				clieToUpdate.setDni(c.getDni());
			}
			
			repositorio.save(clieToUpdate);
		}
	}
	
	public List<Cliente> buscarTodos() {
		return this.repositorio.findAll();
	}
	
	public Cliente findByNombreAndApellidosIgnoreCaseLike(String nombre, String apellidos) {
		return repositorio.findByNombreAndApellidosIgnoreCaseLike(nombre, apellidos);
	}
	
	public List<Cliente> findByNombreIgnoreCaseLike(String nombre) {
		return repositorio.findByNombreIgnoreCaseLike(nombre);
	}

}
