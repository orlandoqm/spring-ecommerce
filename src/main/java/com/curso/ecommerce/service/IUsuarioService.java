/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Usuario;
import java.util.Optional;

/**
 *
 * @author ORLANDO
 */
public interface IUsuarioService {
    
    public Optional <Usuario> finById(Integer id);
    
}
