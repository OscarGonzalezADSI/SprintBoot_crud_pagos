package com.oigonzalezp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String cliente_nombre;
	private String cliente_apellido;
	private String cliente_correo;
	private String credito_numero;
	private String tarjeta_vencimiento;
	private String compra_diferir;
	private String producto_nombre;
	private Long producto_precio;
	private String fecha_transaccion;
	
	public Persona() {
		
	}

	public Persona(int id, String cliente_nombre, String cliente_apellido, String cliente_correo, String credito_numero,
			String tarjeta_vencimiento, String compra_diferir, String producto_nombre, Long producto_precio,
			String fecha_transaccion) {
		super();
		this.id = id;
		this.cliente_nombre = cliente_nombre;
		this.cliente_apellido = cliente_apellido;
		this.cliente_correo = cliente_correo;
		this.credito_numero = credito_numero;
		this.tarjeta_vencimiento = tarjeta_vencimiento;
		this.compra_diferir = compra_diferir;
		this.producto_nombre = producto_nombre;
		this.producto_precio = producto_precio;
		this.fecha_transaccion = fecha_transaccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCliente_nombre() {
		return cliente_nombre;
	}

	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}

	public String getCliente_apellido() {
		return cliente_apellido;
	}

	public void setCliente_apellido(String cliente_apellido) {
		this.cliente_apellido = cliente_apellido;
	}

	public String getCliente_correo() {
		return cliente_correo;
	}

	public void setCliente_correo(String cliente_correo) {
		this.cliente_correo = cliente_correo;
	}

	public String getCredito_numero() {
		return credito_numero;
	}

	public void setCredito_numero(String credito_numero) {
		this.credito_numero = credito_numero;
	}

	public String getTarjeta_vencimiento() {
		return tarjeta_vencimiento;
	}

	public void setTarjeta_vencimiento(String tarjeta_vencimiento) {
		this.tarjeta_vencimiento = tarjeta_vencimiento;
	}

	public String getCompra_diferir() {
		return compra_diferir;
	}

	public void setCompra_diferir(String compra_diferir) {
		this.compra_diferir = compra_diferir;
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

	public String getFecha_transaccion() {
		return fecha_transaccion;
	}

	public void setFecha_transaccion(String string) {
		this.fecha_transaccion = string;
	}
	
}
