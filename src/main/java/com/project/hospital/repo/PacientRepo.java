package com.project.hospital.repo;

import com.project.hospital.pacient.Pacient;
import com.project.hospital.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepo extends JpaRepository<Pacient, Long> {



}
