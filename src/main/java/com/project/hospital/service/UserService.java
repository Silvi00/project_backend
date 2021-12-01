package com.project.hospital.service;

import com.project.hospital.user.User;

import java.util.Collection;

public interface UserService {

    User create(User user);
    Collection<User> list(int limit);
    User get(Long id);

}
