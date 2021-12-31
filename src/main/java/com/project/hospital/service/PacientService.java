package com.project.hospital.service;

import com.project.hospital.pacient.Pacient;
import com.project.hospital.user.User;

import java.util.Collection;

public interface PacientService {

    Pacient create(Pacient pacient);
    Collection<Pacient> list(int limit);
    Pacient get(Long id);

}
