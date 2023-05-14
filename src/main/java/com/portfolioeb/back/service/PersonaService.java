package com.portfolioeb.back.service;

import com.portfolioeb.back.model.Persona;
import com.portfolioeb.back.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository persoRepository;

    @Override
    public List<Persona> getPersons() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePerson(Persona perso) {
        persoRepository.save(perso);
    }

    @Override
    public void deletePerson(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPerson(Long id) {
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
    
    
    public Persona authentication(String email, String password) {
        Persona pers = persoRepository.findByEmail(email);
        if (pers != null && pers.getPassword().equals(password)) {
            return pers;

        } else {
            return null;
        }

    }

    
  

   
}
