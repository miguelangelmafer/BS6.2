package com.bosonit.EJ2.application.Port;

import com.bosonit.EJ2.domain.PersonaEnt;
import com.bosonit.EJ2.infraestructure.DTOs.InputPersonaDTO;

public interface UpdatePersonaPort {

    public PersonaEnt updatePerson(PersonaEnt personaOld, InputPersonaDTO personaNew);
}
