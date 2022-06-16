package com.oigonzalezp.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oigonzalezp.demo.model.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer> {

}
