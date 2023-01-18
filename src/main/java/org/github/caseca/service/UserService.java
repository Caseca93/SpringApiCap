package org.github.caseca.service;

import org.github.caseca.domain.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> listAllUsers();

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
