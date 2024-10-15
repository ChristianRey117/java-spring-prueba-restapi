package com.chris.prueba.prueba_java.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.prueba.prueba_java.Repositories.IProductRepository;
import org.springframework.web.bind.annotation.RequestParam;
import com.chris.prueba.prueba_java.Entities.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

;

@RestController
@RequestMapping("/productos")
public class ProductContoller {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public List<Producto> getAllProducts() {
        return productRepository.findAll();
    }
    
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productRepository.save(producto);
    }

    @GetMapping("{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));

    }
    

    @PutMapping("{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productFinded = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));
        
        productFinded.setNombre(producto.getNombre());
        productFinded.setPrecio(producto.getPrecio());

        return productRepository.save(productFinded);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable Long id){
        Producto productFinded = productRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: " + id));

        productRepository.delete(productFinded);
        return "El producto con el ID: " + id + " fue eliminado";
    }
    


}
