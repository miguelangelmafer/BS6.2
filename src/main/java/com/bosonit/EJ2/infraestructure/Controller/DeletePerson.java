package com.bosonit.EJ2.infraestructure.Controller;


import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.PersonaEntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class DeletePerson {

    @Autowired
    PersonaEntService personaEntService;

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) throws Exception {
        PersonaEnt personaEnt = personaEntService.getPersonaByID(id);
        personaEntService.deletePerson(personaEnt);
        return "Persona eliminada";
    }
}
