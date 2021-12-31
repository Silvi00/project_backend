package com.project.hospital.service.implementation;

import com.project.hospital.pacient.Pacient;
import com.project.hospital.repo.PacientRepo;
import com.project.hospital.repo.UserRepo;
import com.project.hospital.service.PacientService;
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
public class PacientServiceImpl implements PacientService {

    private final PacientRepo pacientRepo;

    @Override
    public Pacient create(Pacient pacient) {
        log.info("Saving new patient: {} {}", pacient.getNume(), pacient.getPrenume());
        return pacientRepo.save(pacient);
    }

    @Override
    public Collection<Pacient> list(int limit) {
        log.info("Fetching all patients");
        return pacientRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Pacient get(Long id) {
        log.info("Fetching patient by id: {}", id);
        return pacientRepo.findById(id).get();
    }
}
