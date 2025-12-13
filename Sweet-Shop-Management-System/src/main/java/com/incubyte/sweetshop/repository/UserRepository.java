package com.incubyte.sweetshop.repository;

import com.incubyte.sweetshop.entity.User;

public interface UserRepository {
    boolean existsByUsername(String username);
    User save(User user);
}

