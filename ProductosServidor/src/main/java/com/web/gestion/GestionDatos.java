package com.web.gestion;

import com.web.modelo.Producto;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.util.List;

//@Singleton
//@Startup
public class GestionDatos{

    /*
    @Inject
    GestionProducto gestionProducto;

    @PostConstruct
    public void init(){
        Producto producto = new Producto();
        producto.setDescripcion("1KG Carne ahumada");
        producto.setPrecio(10.25);
        producto.setIVA('S');
        gestionProducto.guardarProducto(producto);

        List<Producto> productos = gestionProducto.getProductos();
        for(Producto p : productos){
            System.out.println(p);
        }
    }
    */
}
