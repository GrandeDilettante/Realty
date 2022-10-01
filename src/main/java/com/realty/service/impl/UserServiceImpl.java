package com.realty.service.impl;

import com.realty.dto.UserDTO;
import com.realty.entity.RealtyUser;
import com.realty.entity.User;
import com.realty.repository.RealtyUserRepository;
import com.realty.repository.UserRepository;
import com.realty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RealtyUserRepository realtyUserRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RealtyUserRepository realtyUserRepository) {
        this.userRepository = userRepository;
        this.realtyUserRepository = realtyUserRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    @Transactional
    public void addRealtyUser(Long userId, Long realtyId) {
        RealtyUser realtyUser = new RealtyUser();
        realtyUser.setUserId(userId);
        realtyUser.setRealtyId(realtyId);
        realtyUserRepository.save(realtyUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Long> getRealtyIdById(Long id) {
        return userRepository.getRealtyIdById(id);
    }

    @Override
    @Transactional
    public Integer deleteRealtyUser(Long realtyId, Long userId) {
        return realtyUserRepository.deleteByRealtyIdAndUserId(realtyId, userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getRealtyNamesById(Long id) {
        return userRepository.getRealtyNamesById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getAllUsersDTO(Long userId) {
        return userRepository.getAllUsersDTO(userId);
    }
}
