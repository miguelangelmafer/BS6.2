package com.bosonit.EJ2.infraestructure.Controller;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.PersonaEntService;
import com.bosonit.EJ2.infraestructure.PersonaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class CreatePerson {

    @Autowired
    PersonaEntService personaEntService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO) throws Exception {
        PersonaEnt personaEnt = personaEntService.addPersona(modelMapper.map(personaDTO, PersonaEnt.class));
        personaDTO.setId_persona(personaEnt.getId_persona());
        return personaDTO;
    }
}
