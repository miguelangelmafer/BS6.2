package com.bosonit.EJ2.infraestructure.Controller;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.PersonaEntService;
import com.bosonit.EJ2.infraestructure.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")

public class UpdatePerson {

    @Autowired
    PersonaEntService personaEntService;

    @PutMapping("/update/{id}")
    public PersonaEnt updatePersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) throws Exception {
        PersonaEnt personaEnt = personaEntService.getPersonaByID(id);
        personaEntService.updatePerson(personaEnt,personaDTO);
        return personaEnt;
    }
}
