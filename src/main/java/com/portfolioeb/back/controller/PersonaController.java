
package com.portfolioeb.back.controller;

import com.portfolioeb.back.model.Persona;
import com.portfolioeb.back.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/person")
@RestController
@CrossOrigin(origins = "https://backendeb.onrender.com")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServi;
    
     
    @PostMapping("/login")
   
    public ResponseEntity<?> login(@RequestBody Persona pers) {
        Persona perso = persoServi.authentication(pers.getEmail() , pers.getPassword());
        if (perso != null && pers.getPassword().equals(pers.getPassword())) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    
    @GetMapping ("/see")
    @ResponseBody
    public List<Persona> getPersons(){
       
        return      persoServi.getPersons();
    }
    
    @PostMapping ("/new")
    public String addPerson (@RequestBody Persona pers){
        persoServi.savePerson(pers);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping ("/delete/{id}") 
    public String deletePerson (@PathVariable Long id){
    persoServi.deletePerson(id);
    return "La persona fue borrada correctamente";
    }
    
    @PutMapping ("/edit/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("email") String nuevoeMail,
                                @RequestParam ("ocupacion") String nuevaOcupacion,
                                @RequestParam ("img_bg") String nuevaImg,
                                @RequestParam ("nac") String nuevaNac,
                                @RequestParam ("password") String nuevaPassword,
                                @RequestParam ("about") String nuevaAbout) {
        //busco la persona
        Persona perso = persoServi.findPerson(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEmail(nuevoeMail);
        perso.setOcupacion(nuevaOcupacion);
        perso.setImg_bg(nuevaImg);
        perso.setPassword(nuevaPassword);
        perso.setAbout(nuevaAbout);
        perso.setNac(nuevaNac);
        
        return perso;
    }
    
    @GetMapping("/look/profile")
    public Persona findPersona(){
        return persoServi.findPerson((long)1);
    }
    

                                
    
    
}
