package org.github.caseca.service;

import org.github.caseca.domain.entity.User;
import org.github.caseca.rest.controller.dto.UserExitDTO;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<UserExitDTO> listAllUsers();

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
