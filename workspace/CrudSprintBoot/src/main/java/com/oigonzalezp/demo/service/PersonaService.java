package com.oigonzalezp.demo.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oigonzalezp.demo.interfaceService.IPersonaService;
import com.oigonzalezp.demo.interfaces.IPersona;
import com.oigonzalezp.demo.model.Persona;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		try {
			List<Persona> items = null;
			items = (List<Persona>)data.findAll();
			return items;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Persona> listarId(int id) {
		try {
			Optional<Persona> item = null;
			item = data.findById(id);
			return item;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int save(Persona p) {
		int res = 0;
		try {
			int aut = validaTransaccion(p);
			if(aut == 1) {
				Persona persona=data.save(p);
				if(!persona.equals(null))
				{
					res=1;
				}				
			}
			return res;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	private int validaTransaccion(Persona p) {
		
		int res=0, cantTransacciones = 0;
		float contabilidad = 0;
		boolean superaTopeMx = false;
		
		p.setFecha_transaccion(LocalDate.now().toString());
		
		List<Persona> items = listar();
		Iterator<Persona> iter = items.iterator();

		while(iter.hasNext())
		{
			Persona next = iter.next();
			
			if(validaTarjetaCredito(next, p) && validaFechaTransaccion(next, p))
			{
				contabilidad = validaMontoMaximoCompra(next) ? totalizaCompras(next, contabilidad) : contabilidad;
				cantTransacciones = validaMontoMaximoCompra(next) ? cantTransacciones + 1 : cantTransacciones;
			}
		}

		res = contextResponse(superaTopeMx, contabilidad, cantTransacciones);
		
		return res;
	}
	
	private boolean validaTarjetaCredito(Persona next, Persona p)
	{
		boolean res = next.getCredito_numero().equals(p.getCredito_numero());
		return res;
	}
	
	private boolean validaFechaTransaccion(Persona next, Persona p)
	{
		boolean res = next.getFecha_transaccion().equals(LocalDate.now().toString());
		return res;
	}
	
	private boolean validaMontoMaximoCompra(Persona next)
	{
		int montoMaximo = 10000000;
		return (next.getProducto_precio() < montoMaximo) ? true : false;
	}
	
	private float totalizaCompras(Persona next, float sumatoria)
	{
		float res = sumatoria + next.getProducto_precio();
		return res;
	}
	
	private int contextResponse(boolean superaTopeMx, float contabilidad, int cantTransacciones)
	{
		int res;
		if(superaTopeMx) {
			res = 4;
		}else if(contabilidad>5000000) {
			res = 3;
		}else if(cantTransacciones > 5) {
			res = 2;
		}else {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		try {
			data.deleteById(id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
