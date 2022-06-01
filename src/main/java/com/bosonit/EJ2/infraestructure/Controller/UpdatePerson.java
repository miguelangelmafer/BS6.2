package com.bosonit.EJ2.infraestructure.Controller;

import com.bosonit.EJ2.application.Port.UpdatePersonaPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/person")

public class UpdatePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/update/{id}")
    public PersonaEnt updatePersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) throws Exception {
        try{
            PersonaEnt personaEnt = getPersonUseCase.getPersonaByID(id);
            updatePersonaPort.updatePerson(personaEnt,personaDTO);
            return personaEnt;
        }catch (Exception e){
            throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
