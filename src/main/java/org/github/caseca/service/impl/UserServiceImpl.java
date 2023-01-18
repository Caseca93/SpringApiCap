package org.github.caseca.service.impl;

import lombok.RequiredArgsConstructor;
import org.github.caseca.domain.entity.User;
import org.github.caseca.domain.repository.UserRepository;
import org.github.caseca.exception.RegraDeNegocioExecpetion;
import org.github.caseca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userModel = userRepository.findById(id);
        userModel.map(user1 -> {
            user.setId(user1.getId());
            userRepository.save(user);
            return user;
        }).orElseThrow(() -> new RegraDeNegocioExecpetion("Código do usuario inválido"));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userExist = userRepository.findById(id);
        userExist.map(user -> {
            userRepository.deleteById(id);
            return user;
        }).orElseThrow(() -> new RegraDeNegocioExecpetion("Código do usuario inválido"));
    }
}
