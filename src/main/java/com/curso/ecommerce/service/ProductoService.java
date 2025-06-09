/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Producto;
import java.util.Optional;

/**
 *
 * @author ORLANDO
 */
public interface ProductoService {
    public Producto save( Producto producto);
    public Optional <Producto> get(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
    
    
}
