package com.realty.service;

import com.realty.dto.UserDTO;
import com.realty.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAll(Pageable pageable);

    List<User> getAll();

    User getById(Long id);

    User save(User user);

    void deleteById(Long id);

    boolean existsById(Long id);

    void addRealtyUser(Long userId, Long realtyId);

    List<Long> getRealtyIdById(Long id);

    Integer deleteRealtyUser(Long realtyId, Long userId);

    List<String> getRealtyNamesById(Long id);

    UserDTO getAllUsersDTO(Long id);
}
