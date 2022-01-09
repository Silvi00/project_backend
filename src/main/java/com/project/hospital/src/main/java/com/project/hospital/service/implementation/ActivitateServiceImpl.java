package com.project.hospital.service.implementation;

import com.project.hospital.activitate.Activitate;
import com.project.hospital.repo.ActivitateRepo;
import com.project.hospital.repo.UserRepo;
import com.project.hospital.service.ActivitateService;
import com.project.hospital.service.UserService;
import com.project.hospital.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ActivitateServiceImpl implements ActivitateService {

    private final ActivitateRepo activitateRepo;

    @Override
    public Activitate create(Activitate activitate) {
        log.info("Saving new user: {} {}", activitate.getSubiect(), activitate.getData());
        return activitateRepo.save(activitate);
    }

    @Override
    public Collection<Activitate> list(int limit) {
        log.info("Fetching all users");
        return activitateRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Activitate get(Long id) {
        log.info("Fetching user by id: {}", id);
        return activitateRepo.findById(id).get();
    }
}
