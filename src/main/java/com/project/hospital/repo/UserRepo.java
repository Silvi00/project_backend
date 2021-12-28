package com.project.hospital.repo;

import com.project.hospital.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByLastName(String lastName);
    Optional<User> findByEmail(String email);

}
