package com.bosonit.EJ2.application.Port;


import com.bosonit.EJ2.domain.PersonaEnt;

public interface CreatePersonPort {
    public PersonaEnt addPersona(PersonaEnt personaEnt) throws Exception;
}
