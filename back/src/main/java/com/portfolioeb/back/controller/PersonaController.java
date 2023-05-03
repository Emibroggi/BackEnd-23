
package com.portfolioeb.back.controller;

import com.portfolioeb.back.model.Persona;
import com.portfolioeb.back.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServi;
    
    @GetMapping ("see/person")
    @ResponseBody
    public List<Persona> getPersons(){
       
        return      persoServi.getPersons();
    }
    
    @PostMapping ("/new/person")
    public String addPerson (@RequestBody Persona pers){
        persoServi.savePerson(pers);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping ("person/delete/{id}") 
    public String deletePerson (@PathVariable Long id){
    persoServi.deletePerson(id);
    return "La persona fue borrada correctamente";
    }
    
    @PutMapping ("person/edit/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("email") String nuevoeMail,
                                @RequestParam ("ocupacion") String nuevaOcupacion,
                                @RequestParam ("img_bg") String nuevaImg) {
        //busco la persona
        Persona perso = persoServi.findPerson(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEmail(nuevoeMail);
        perso.setOcupacion(nuevaOcupacion);
        perso.setImg_bg(nuevaImg);
        
        
        return perso;
    }
    
    @GetMapping("person/look/profile")
    public Persona findPersona(){
        return persoServi.findPerson((long)1);
    }
    

                                
    
    
}
