package com.bosonit.EJ2.application.Port;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.PersonaDTO;

public interface UpdatePersonaPort {

    public PersonaEnt updatePerson(PersonaEnt personaOld, PersonaDTO personaNew);
}
