package com.project.hospital.service;

import com.project.hospital.activitate.Activitate;
import com.project.hospital.user.User;

import java.util.Collection;

public interface ActivitateService {

    Activitate create(Activitate activitate);
    Collection<Activitate> list(int limit);
    Activitate get(Long id);

}
