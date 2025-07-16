/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ecommerce.controller;

import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.IUsuarioService;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ORLANDO
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/registro")
    public String create(){
        
        return "usuario/registro";
    }
    
    @PostMapping("/save")
    public String save (Usuario usuario){
        
        LOGGER.info("datos del usuario {}",usuario);
        usuario.setTipo("USER");
        usuarioService.save(usuario);
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String login(){
        
        return "usuario/login";
    }
    
    @PostMapping("/acceder")
    public String acceder(Usuario usuario, HttpSession sesion){
        LOGGER.info("Datos del usuario {}",usuario);
        Optional<Usuario> user= usuarioService.findByEmail(usuario.getEmail());
        //LOGGER.info("datos usuario encontrado{}",user.get());
        
        if(user.isPresent()){
            sesion.setAttribute("idusuario", user.get().getId());
            if(user.get().getTipo().equals("ADMIN")){
                return "redirect:/administrador";
            }else{
                return "redirect:/";
            }
        }else{
            LOGGER.info("usuario no exite");
        }
        
        return "redirect:/";
    }
    
}
