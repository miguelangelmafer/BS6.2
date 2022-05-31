package com.bosonit.EJ2.infraestructure.Controller;

import com.bosonit.EJ2.application.Port.CreatePersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.UseCase.GetPersonUseCase;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;
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
    GetPersonUseCase getPersonUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CreatePersonPort createPersonPort;

    @PostMapping("/add")
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO) throws Exception {
        PersonaEnt personaEnt = createPersonPort.addPersona(modelMapper.map(personaDTO, PersonaEnt.class));
        personaDTO.setId_persona(personaEnt.getId_persona());
        return personaDTO;
    }
}
