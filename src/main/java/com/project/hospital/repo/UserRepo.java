package com.project.hospital.repo;

import com.project.hospital.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByLastName(String lastName);

}
