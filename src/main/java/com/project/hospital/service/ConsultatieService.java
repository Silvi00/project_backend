package com.project.hospital.service;

import com.project.hospital.consultatie.Consultatie;
import com.project.hospital.pacient.Pacient;

import java.util.Collection;

public interface ConsultatieService {
    Consultatie create(Consultatie c);
    Collection<Consultatie> list(int limit);
    Consultatie get(Long id);

}
