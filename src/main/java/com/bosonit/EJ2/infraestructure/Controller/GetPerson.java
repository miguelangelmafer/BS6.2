package com.bosonit.EJ2.infraestructure.Controller;


import com.bosonit.EJ2.Exceptions.NotFoundException;
import com.bosonit.EJ2.application.Port.GetPersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.OutPutPersonaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class GetPerson {

    @Autowired
    GetPersonPort getPersonPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")

    public OutPutPersonaDTO getPersonByID(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = getPersonPort.getPersonaByID(id);
            OutPutPersonaDTO outPutPersonaDTO = modelMapper.map(personaEnt,OutPutPersonaDTO.class);
            return outPutPersonaDTO;
        } catch (Exception e) {
            throw new NotFoundException("No se encuentra el ususario " + id);
        }
    }

    @GetMapping("/name/{nombre}")
    public List<OutPutPersonaDTO> getPersonByName(@PathVariable String nombre) throws Exception {
        List <PersonaEnt> personaEntList = getPersonPort.getPersonByName(nombre);
        TypeToken<List<OutPutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<OutPutPersonaDTO> outPutPersonaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return outPutPersonaDTOList;
    }

    @GetMapping("/all")
    public List<OutPutPersonaDTO> getAllPerson(){
        List <PersonaEnt> personaEntList = getPersonPort.getAllPerson();
        TypeToken<List<OutPutPersonaDTO>> typeToken = new TypeToken<>() {
        };
        List<OutPutPersonaDTO> outPutPersonaDTOList = modelMapper.map(personaEntList, typeToken.getType());
        return outPutPersonaDTOList;
    }

}



