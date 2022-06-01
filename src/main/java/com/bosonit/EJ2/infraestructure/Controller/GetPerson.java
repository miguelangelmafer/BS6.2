package com.bosonit.EJ2.infraestructure.Controller;


import com.bosonit.EJ2.application.Port.GetPersonPort;
import com.bosonit.EJ2.application.UseCase.ModelMapperConfiguration;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@RestController
@RequestMapping("/person")
public class GetPerson {

    @Autowired
    GetPersonPort getPersonPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")

    public PersonaDTO getPersonByID(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = getPersonPort.getPersonaByID(id);
            PersonaDTO personaDTO = modelMapper.map(personaEnt,PersonaDTO.class);
            return personaDTO;
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{nombre}")
    public List<PersonaDTO> getPersonByName(@PathVariable String nombre) throws Exception {
        List <PersonaEnt> personaEntList = getPersonPort.getPersonByName(nombre);
        TypeToken<List<PersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<PersonaDTO> personaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return personaDTOList;
    }

    @GetMapping("/all")
    public List<PersonaDTO> getAllPerson(){
        List <PersonaEnt> personaEntList = getPersonPort.getAllPerson();
        TypeToken<List<PersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<PersonaDTO> personaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return personaDTOList;
    }

}



