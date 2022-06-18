package com.oigonzalezp.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oigonzalezp.demo.interfaceService.IPersonaService;
import com.oigonzalezp.demo.interfaceService.IProductoService;
import com.oigonzalezp.demo.model.Persona;
import com.oigonzalezp.demo.model.Producto;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
    private IPersonaService service;
	
	@Autowired
    private IProductoService serviceProducto;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		List<Producto>productos=serviceProducto.listar();
		model.addAttribute("productos", productos);
		model.addAttribute("persona", new Persona());
		return "formInsertar";
	}
	
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		int resp = service.save(p);
		if(resp == 1) {
			return "redirect:/informacionPago/"+p.getId();
		}else if(resp == 2) {
			return "redirect:/registroPagoFallidoMax";
		}else if(resp == 3) {
			return "redirect:/registroPagoFallidoAcum";
		}else if(resp == 4) {
			return "redirect:/registroPagoFallidoTope";
		}
		return "/registroPagoFallido";
	}
	
	@GetMapping("/informacionPago/{id}")
	public String volver(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona", persona);
		return "informacionPago";
	}
	
	@GetMapping("/registroPagoFallido")
	public String registroPagoFallido() {
		return "registroPagoFallido";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona", persona);
		return "formModificar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/listarProductos")
	public String listarProducto(Model model) {
		List<Producto>productos=serviceProducto.listar();
		model.addAttribute("productos", productos);
		return "producto";
	}
	
	@GetMapping("/nuevoProducto")
	public String agregarProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "formProductoInsertar";
	}
	
	@PostMapping("/saveProduct")
	public String save(@Validated Producto p, Model model) {	
		int resp = serviceProducto.save(p);
		if(resp == 1) {
			return "redirect:/registroProductoExitoso";
		}
		return "/registroProductoFallido";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable int id, Model model) {
		Optional<Producto>producto=serviceProducto.listarId(id);
		model.addAttribute("producto", producto);
		return "formProductoModificar";
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String deleteProduct(Model model, @PathVariable int id) {
		serviceProducto.delete(id);
		return "redirect:/listarProductos";
	}
	
	@GetMapping("/registroProductoExitoso")
	public String registroProductoExitoso() {
		return "registroProductoExitoso";
	}

	@GetMapping("/registroPagoFallidoAcum")
	public String registroPagoFallidoAcum() {
		return "registroPagoFallidoAcum";
	}

	@GetMapping("/registroPagoFallidoMax")
	public String registroPagoFallidoMax() {
		return "registroPagoFallidoMax";
	}

	@GetMapping("/registroPagoFallidoTope")
	public String registroPagoFallidoTope() {
		return "registroPagoFallidoTope";
	}

	@GetMapping("/mensajeError")
	public String mensajeError() {
		return "mensajeError";
	}
	
}
