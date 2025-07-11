/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ecommerce.service;

import com.curso.ecommerce.model.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.ecommerce.repository.IUserRepository;

/**
 *
 * @author ORLANDO
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<Usuario> finById(Integer id) {
     return userRepository.findById(id);
    }

   

    
    
}
