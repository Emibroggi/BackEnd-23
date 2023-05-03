/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioeb.back.service;

import com.portfolioeb.back.model.Experiencia;
import com.portfolioeb.back.repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;
    
    public List <Experiencia> list(){
        return experienciaRepository.findAll();
    }
    
    public Optional <Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    
    public Optional <Experiencia> getByNombreE(String nombreE){
        return experienciaRepository.findByNombreE(nombreE);
    }
    
    public void save (Experiencia expe){
        experienciaRepository.save(expe);
    }
    
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return experienciaRepository.existsByNombreE(nombreE);
    }
    
    
}
