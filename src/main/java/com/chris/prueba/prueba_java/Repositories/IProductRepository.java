package com.chris.prueba.prueba_java.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.prueba.prueba_java.Entities.Producto;

public interface IProductRepository extends JpaRepository<Producto, Long>{

    
}
