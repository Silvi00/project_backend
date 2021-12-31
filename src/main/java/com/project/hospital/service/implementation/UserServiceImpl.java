package com.project.hospital.service.implementation;

import com.project.hospital.repo.UserRepo;
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
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(User user) {
        log.info("Saving new user: {} {}", user.getFirstName(), user.getLastName());
        return userRepo.save(user);
    }

    @Override
    public Collection<User> list(int limit) {
        log.info("Fetching all users");
        return userRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User get(Long id) {
        log.info("Fetching user by id: {}", id);
        return userRepo.findById(id).get();
    }
}
