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
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {

		int res=0;
		int numTran = 0;
		float sumatoria = 0;
		boolean topeMx = false;
		p.setFecha_transaccion(LocalDate.now().toString());
		List<Persona> items2 = listar();
		Iterator<Persona> iter2 = items2.iterator();

		while(iter2.hasNext()){
			Persona next2 = iter2.next();
			if(next2.getCredito_numero().equals(p.getCredito_numero())) {
				if(next2.getFecha_transaccion().equals(LocalDate.now().toString())) {
					if(next2.getProducto_precio()<10000000) {
						sumatoria = sumatoria + next2.getProducto_precio();
						numTran=numTran+1;
					} else {
						topeMx=true;
					}
				}
			}
		}

		if(topeMx) {
			res=4;
		}else if(sumatoria>5000000){
			res=3;
		}else if(numTran>5){
			res=2;
		}else {
			Persona persona=data.save(p);
			if(!persona.equals(null))
			{
				res=1;
			}		
		}
		return res;			
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
