package com.bosonit.EJ2.application.Port;

import com.bosonit.EJ2.domain.PersonaEnt;

import java.util.List;

public interface GetPersonPort {

    public PersonaEnt getPersonaByID(Integer id) throws Exception;

    public List<PersonaEnt> getPersonByName(String name);

    public List<PersonaEnt> getAllPerson();

}
