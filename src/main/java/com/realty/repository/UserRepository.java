package com.realty.repository;

import com.realty.dto.UserDTO;
import com.realty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT DISTINCT ru.realtyId FROM RealtyUser ru WHERE ru.userId = :id")
    List<Long> getRealtyIdById(Long id);

    @Query("SELECT r.name FROM RealtyUser ru " +
            "JOIN Realty r ON ru.realtyId = r.id " +
            "WHERE ru.userId = ?1")
    List<String> getRealtyNamesById(Long id);

    @Query("SELECT new com.realty.dto.UserDTO(u.name, u.budget) FROM User u ")
    UserDTO getAllUsersDTO(Long id);
}
