package com.bosonit.EJ2.infraestructure.Controller;


import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.PersonaEntService;
import com.bosonit.EJ2.infraestructure.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class GetPerson {

    @Autowired
    PersonaEntService personaEntService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/id/{id}")

    public PersonaDTO getPersonByID(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = personaEntService.getPersonaByID(id);
            PersonaDTO personaDTO = modelMapper.map(personaEnt,PersonaDTO.class);
            return personaDTO;
        } catch (Exception e) {
            throw new Exception("No se encuentra la persona");
        }
    }

    @GetMapping("/name/{nombre}")
    public List<PersonaDTO> getPersonByName(@PathVariable String nombre) throws Exception {
        List <PersonaEnt> personaEntList = personaEntService.getPersonByName(nombre);
        TypeToken<List<PersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<PersonaDTO> personaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return personaDTOList;
    }

    @GetMapping("/all")
    public List<PersonaDTO> getAllPerson(){
        List <PersonaEnt> personaEntList = personaEntService.getAllPerson();
        TypeToken<List<PersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<PersonaDTO> personaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return personaDTOList;
    }

}



