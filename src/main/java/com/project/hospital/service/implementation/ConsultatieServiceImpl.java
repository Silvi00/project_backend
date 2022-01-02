package com.project.hospital.service.implementation;

import com.project.hospital.consultatie.Consultatie;
import com.project.hospital.pacient.Pacient;
import com.project.hospital.repo.ConsultatieRepo;
import com.project.hospital.repo.PacientRepo;
import com.project.hospital.service.ConsultatieService;
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
public class ConsultatieServiceImpl implements ConsultatieService {
    private final ConsultatieRepo consultatieRepo;

    @Override
    public Consultatie create(Consultatie consultatie) {
        log.info("Saving new patient: {} {}", consultatie.getNume(), consultatie.getDataConsultatie());
        return consultatieRepo.save(consultatie);
    }

    @Override
    public Collection<Consultatie> list(int limit) {
        log.info("Fetching all patients");
        return consultatieRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Consultatie get(Long id) {
        log.info("Fetching patient by id: {}", id);
        return consultatieRepo.findById(id).get();
    }
}
