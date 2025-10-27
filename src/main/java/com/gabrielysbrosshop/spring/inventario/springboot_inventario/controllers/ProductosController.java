package com.gabrielysbrosshop.spring.inventario.springboot_inventario.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;

@Controller
public class ProductosController {

    /*
     * Método Get ---> Consultar
     */
    @GetMapping("/productos") /* Endpoint: /productos [GET] */

    public String info(Model model) {
        model.addAttribute("Titulo", "¡Bienvenido a Gabriely's Bros Shop!");

        return "productos";

    }

    /*
     * Método Post ---> Insertar
     */
    @PostMapping("/agregarproductos") /* Endpoint: /agregarprodcutos [POST] */
    /*
     * public ResponseEntity<Producto> agregarProducto(@RequestBody Producto
     * producto){
     * System.out.println("Producto recibido: " + producto.getNombre() +
     * ", Precio: " +
     * producto.getPrecio());
     */

    /*
     * public ResponseEntity<Producto> agregarProducto(@RequestBody Producto
     * productorecibido) {
     * System.out.println(
     * "Producto recibido: " + productorecibido.getNombre() + ", Precio: " +
     * productorecibido.getPrecio());
     * // Aquí podrías agregar lógica para guardar el producto en una base de datos
     * Producto spiderman = new Producto();
     * spiderman.setId(200L);
     * spiderman.setNombre("Spiderman");
     * spiderman.setPrecio(productorecibido.getPrecio());
     * /*
     * producto.setId(99L);
     * producto.setPrecio(productorecibido.getPrecio());
     * 
     * 
     * return new ResponseEntity<>(producto, HttpStatus.CREATED);
     */
    /* return new ResponseEntity<>(spiderman, HttpStatus.CREATED); */
    public ResponseEntity<Productos> agregarProductos(@RequestBody Productos productos) {
        System.out.println("Producto recibido: " + productos.getNombre() + " Precio: " + productos.getPrecio() +
                " Descripción: " + productos.getDescripcion() + " Cantidad en Stock: " + productos.getCantidadEnStock()
                +
                " Categoría: " + productos.getCategoria());
        int result = Gabrielys_Bros_DB.guardarProductos(productos);
        System.out.println("Filas insertadas: " + result);
        return new ResponseEntity<>(productos, HttpStatus.CREATED);

    }

}

// Médoto Put ---> Actualizar

// Médoto Delete ---> >Eliminar
