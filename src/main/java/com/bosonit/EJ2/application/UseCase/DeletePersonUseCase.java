package com.bosonit.EJ2.application.UseCase;

import com.bosonit.EJ2.application.Port.DeletePersonPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase implements DeletePersonPort {

    @Autowired
    PersonaRepository personaRepository;

    public void deletePerson(PersonaEnt personaEnt){
        personaRepository.delete(personaEnt);
    }
}
