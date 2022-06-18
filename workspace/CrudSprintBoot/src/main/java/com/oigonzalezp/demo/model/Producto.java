package com.oigonzalezp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String producto_nombre;
	private Long producto_precio;
	
	public Producto() {
		
	}
	
	public Producto(int id, String producto_nombre, Long producto_precio) {
		super();
		this.id = id;
		this.producto_nombre = producto_nombre;
		this.producto_precio = producto_precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducto_nombre() {
		return producto_nombre;
	}

	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}

	public Long getProducto_precio() {
		return producto_precio;
	}

	public void setProducto_precio(Long producto_precio) {
		this.producto_precio = producto_precio;
	}

}
