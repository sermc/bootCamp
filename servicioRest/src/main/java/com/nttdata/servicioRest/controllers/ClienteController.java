package com.nttdata.servicioRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.servicioRest.entity.Cliente;
import com.nttdata.servicioRest.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="clientesapi")
public class ClienteController {
	
	@Autowired
	ClienteService servicio;
	
	@ApiOperation(value = "Listado todos los clientes", response = Cliente.class)
	@RequestMapping(value="listar", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Cliente>> getClientes(Model modelAndView){
		return ResponseEntity.ok(servicio.buscarTodos());
	}
	
	@ApiOperation(value = "Añadir un cliente", response = Cliente.class)
	@PostMapping("insert")
	public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente c,Model modelAndView) {		
		return ResponseEntity.ok(servicio.insert(c));
	}
	
	@ApiOperation(value = "Eliminar un cliente", response = Cliente.class)
	@RequestMapping(value="delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id,Model modelAndView) {
		return ResponseEntity.ok(servicio.delete(id));
	}
	
	@ApiOperation(value = "Filtrar clientes por nombre", response = Cliente.class)
	@RequestMapping(value="searchByName/{nombre}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<List<Cliente>> getClientesByName(@PathVariable("nombre") String nombre){
		return ResponseEntity.ok(servicio.findByNombreIgnoreCaseLike(nombre));
	}
}
