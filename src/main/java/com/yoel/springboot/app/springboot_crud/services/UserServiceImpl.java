package com.yoel.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoel.springboot.app.springboot_crud.entities.Role;
import com.yoel.springboot.app.springboot_crud.entities.User;
import com.yoel.springboot.app.springboot_crud.repositories.RoleRepository;
import com.yoel.springboot.app.springboot_crud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
     @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {

        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRole.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> adminRoleOpt = roleRepository.findByName("ROLE_ADMIN");
            adminRoleOpt.ifPresent(roles::add);
        }

        user.setRoles(roles);
        String passwordEncoded =passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
       Optional<User> userOpt = userRepository.findById(id);
       userOpt.ifPresent(user -> userRepository.delete(user));
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setRoles(user.getRoles());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

}
