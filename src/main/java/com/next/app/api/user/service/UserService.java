package com.next.app.api.user.service;

import com.next.app.api.user.entity.User;
import com.next.app.api.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByContactEmail(email);
    }

    public User createUser(User user) {
        if (userRepository.existsByContactEmail(user.getContactEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다: " + user.getContactEmail());
        }

        log.info("Creating user: " + user.getContactEmail());

        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + id));

        user.setCompanyName(userDetails.getCompanyName());
        user.setRepresentativeName(userDetails.getRepresentativeName());
        user.setContactEmail(userDetails.getContactEmail());
        user.setContactPhone(userDetails.getContactPhone());
        user.setAddress(userDetails.getAddress());
        user.setBusinessNumber(userDetails.getBusinessNumber());
        user.setRegisteredAt(userDetails.getRegisteredAt());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
