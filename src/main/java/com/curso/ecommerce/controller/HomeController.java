/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ecommerce.controller;

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.model.Orden;
import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ORLANDO
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private ProductoService productoService;
    //lista de todos los detalles 
    List<DetalleOrden> detalles= new ArrayList<DetalleOrden>();
    
    Orden orden= new Orden();

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("productos", productoService.findAll());

        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model) {
        Optional<Producto> optionProducto = productoService.get(id);
        if (optionProducto.isPresent()) {
            Producto producto = optionProducto.get();
            model.addAttribute("producto", producto);
        } else {
            LOGGER.warn("Producto no encontrado con id: {}", id);
            return "redirect:/error"; // o devuelve una vista de error
        }
        return "usuario/productohome";
    }
    
    @PostMapping("/cart")
    public String addCar(@RequestParam Integer id, @RequestParam Integer cantidad, Model model){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal= 0;
        
       Optional<Producto> optionalProducto= productoService.get(id);
       LOGGER.info("Detalles del producto {}",optionalProducto.get());
       LOGGER.info("cantidad de productos {}",cantidad);
       
       producto= optionalProducto.get();
       
       detalleOrden.setNombre(producto.getNombre());
       detalleOrden.setCantidad(cantidad);
       detalleOrden.setPrecio(producto.getPrecio());
       detalleOrden.setProducto(producto);
       detalleOrden.setTotal(producto.getPrecio()*cantidad);
       
       detalles.add(detalleOrden);
       sumaTotal=detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
       orden.setTotal(sumaTotal);
       
       model.addAttribute("cart", detalles);
       model.addAttribute("orden", orden);
       
        
        return "usuario/carrito";
    }
    
    @GetMapping("/delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model){
        
        List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();
        
        //eliminacion de un dato por el id en una lista
        for(DetalleOrden detalleOrden : detalles ){
            if(detalleOrden.getProducto().getId() != id){
                ordenesNueva.add(detalleOrden);
            }           
        }
        
        detalles= ordenesNueva;
        
        double sumaTotal = 0;
        sumaTotal=detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
       orden.setTotal(sumaTotal);
       
       model.addAttribute("cart", detalles);
       model.addAttribute("orden", orden);
        
        
        return "usuario/carrito";
    }

}
