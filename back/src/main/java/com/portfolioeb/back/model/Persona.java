
package com.portfolioeb.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
       @Id
       @GeneratedValue(strategy=GenerationType.SEQUENCE)
       private Long id;
       private String nombre;
       private String apellido;
       private String email;
       private String ocupacion;
       private String img_bg;
       
}
