/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.ecommerce.service;

import com.curso.ecommerce.model.DetalleOrden;
import com.curso.ecommerce.repository.IDetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ORLANDO
 */
@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService{

    @Autowired
    private IDetalleOrdenRepository detalleRepository;
    
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
    return detalleRepository.save(detalleOrden);
    }
    
}
