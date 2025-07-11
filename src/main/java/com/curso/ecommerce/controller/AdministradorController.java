/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ecommerce.controller;


import com.curso.ecommerce.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.curso.ecommerce.service.IProductoService;

/**
 *
 * @author ORLANDO
 */
@Controller
@RequestMapping("/administrador")
public class AdministradorController {
   
    @Autowired
    private IProductoService productoService;
    @GetMapping("")
    public String home(Model model){
        
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "administrador/home";
    }
    
}
