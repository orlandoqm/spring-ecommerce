/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.curso.ecommerce.repository;

import com.curso.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ORLANDO
 */
public interface ProductoRepository  extends JpaRepository<Producto, Integer>{
    
}
