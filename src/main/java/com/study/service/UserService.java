package com.study.service;

import com.study.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User findById(Integer id);

    List<User> getAll();

    User editUser(User user);

    void deleteUser(Integer id);
}
