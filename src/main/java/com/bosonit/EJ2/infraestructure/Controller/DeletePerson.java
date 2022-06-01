package com.bosonit.EJ2.infraestructure.Controller;


import com.bosonit.EJ2.application.Port.DeletePersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.application.UseCase.GetPersonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/person")
public class DeletePerson {

    @Autowired
    GetPersonUseCase getPersonUseCase;

    @Autowired
    DeletePersonPort deletePersonPort;

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) throws Exception {
        try {
            PersonaEnt personaEnt = getPersonUseCase.getPersonaByID(id);
            deletePersonPort.deletePerson(personaEnt);
            return "Persona eliminada";
        } catch (Exception e) {
          throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}