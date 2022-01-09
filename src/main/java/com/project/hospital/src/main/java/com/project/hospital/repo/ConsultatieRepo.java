package com.project.hospital.repo;

import com.project.hospital.consultatie.Consultatie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultatieRepo extends JpaRepository<Consultatie, Long> {

}
