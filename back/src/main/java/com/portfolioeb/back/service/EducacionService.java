
package com.portfolioeb.back.service;

import com.portfolioeb.back.model.Educacion;
import com.portfolioeb.back.repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired 
    EducacionRepository educacionRepository;
    
    
    public List <Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional <Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }
    
    public Optional <Educacion> getByNombre(String nombreE){
        return educacionRepository.findByNombreE(nombreE);
    }
    
    public void save (Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void delete(int id){
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return educacionRepository.existsByNombreE(nombreE);
    }
    
    
}
