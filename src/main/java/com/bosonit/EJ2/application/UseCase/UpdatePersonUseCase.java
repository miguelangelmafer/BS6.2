package com.bosonit.EJ2.application.UseCase;

import com.bosonit.EJ2.application.Port.UpdatePersonaPort;
import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;
import com.bosonit.EJ2.infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonaPort {

    @Autowired
    PersonaRepository personaRepository;
    public PersonaEnt updatePerson(PersonaEnt personaOld, PersonaDTO personaNew) {

        personaOld.setPassword(personaNew.getPassword());
        personaOld.setName(personaNew.getName());
        personaOld.setSurname(personaNew.getSurname());
        personaOld.setCompany_email(personaNew.getCompany_email());
        personaOld.setPersona_email(personaNew.getPersona_email());
        personaOld.setCity(personaNew.getCity());
        personaOld.setActive(personaNew.getActive());
        personaOld.setCreated_date(personaNew.getCreated_date());
        personaOld.setImagen_url(personaNew.getImagen_url());
        personaOld.setTermination_date(personaNew.getTermination_date());
        personaOld.setUsuario(personaNew.getUsuario());
        personaOld.setId_persona(personaOld.getId_persona());

        return personaRepository.save(personaOld);
    }
}
