package com.nttdata.servicioRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	  
	@Column(name="APELLIDOS",nullable=false)
	private String apellidos;
	
	@Column(name="FECHA_NACIMIENTO",nullable=false)
	private String fechaNacimiento;
	 
	@Column(name="dni",unique=true,nullable=false,length=9)
	private String dni;

	public Cliente(String nombre, String apellidos, String fechaNacimiento, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}
	
}
