package com.bosonit.EJ2.infraestructure.Controller;

import com.bosonit.EJ2.Exceptions.NotFoundException;
import com.bosonit.EJ2.Exceptions.UnprocesableException;
import com.bosonit.EJ2.application.Port.UpdatePersonaPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")

public class UpdatePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;

    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PutMapping("/update/{id}")
    public PersonaEnt updatePersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) throws Exception{
            PersonaEnt personaEnt = getPersonUseCase.getPersonaByID(id);
            if(personaDTO.getUsuario().length()>10){
                throw new UnprocesableException("Usuario debe tener menos de 10 caracteres");
            }
        if(personaDTO.getUsuario() == null || personaDTO.getPassword() == null || personaDTO.getName() == null ||
                personaDTO.getCompany_email() == null || personaDTO.getPersona_email() == null || personaDTO.getCity() == null ||
                personaDTO.getActive() == null || personaDTO.getCreated_date() == null){
            throw new UnprocesableException("Alguno de los campos no puede ser nulo");
        }
        else
            updatePersonaPort.updatePerson(personaEnt,personaDTO);
            return personaEnt;
        }

    }

