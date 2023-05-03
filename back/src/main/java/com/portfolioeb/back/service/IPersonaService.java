
package com.portfolioeb.back.service;

import com.portfolioeb.back.model.Persona;
import java.util.List;



 public interface IPersonaService {
    //metod para buscar
    public List<Persona> getPersons();
     
    //metodo para agregar
    public void savePerson (Persona perso);
    
    //metodo para borrar
    public void deletePerson (Long id);
    
    //metodo para encontrar
    public Persona findPerson (Long id);
    
}
