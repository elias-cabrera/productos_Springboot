package com.gabrielysbrosshop.spring.inventario.springboot_inventario.controllers;

import javax.swing.text.html.HTML.Attribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ProductosController {

    /* Endpoint: /productos [GET] */
    @GetMapping("/productos")

    public String info(Model model) {
        /*
         * model.addAttribute(attributeName:"Titulo",
         * attributeValue:"¡Biennvenido a Gabrielys Bros Shop!");
         */
        /*
         * model.addAttribute(attributeName:"Servidor",
         * attributeValue:"Gabrielys Bros Shop");
         */

        return "productos";

    }
}