package com.realty.service.impl;

import com.realty.dto.RealtyUserDTO;
import com.realty.entity.RealtyUser;
import com.realty.repository.RealtyRepository;
import com.realty.entity.Realty;
import com.realty.repository.RealtyUserRepository;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RealtyServiceImpl implements RealtyService {

    private final RealtyRepository realtyRepository;

    private final RealtyUserRepository realtyUserRepository;

    @Autowired
    public RealtyServiceImpl(RealtyRepository realtyRepository, RealtyUserRepository realtyUserRepository) {
        this.realtyRepository = realtyRepository;
        this.realtyUserRepository = realtyUserRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Realty> getAll(Pageable pageable) {
        return realtyRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Realty getById(Long id) {
       return realtyRepository.getReferenceById(id);
    }

    @Transactional
    @Override
    public Realty save(Realty realty) {
        return realtyRepository.save(realty);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
            realtyRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Long id) {
        return !realtyRepository.existsById(id);
    }

    @Transactional
    @Override
    public void addUser(Long realtyId, Long userId) {
        RealtyUser realtyUser = new RealtyUser();
        realtyUser.setRealtyId(realtyId);
        realtyUser.setUserId(userId);
        realtyUserRepository.save(realtyUser);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Long> getUsersById(Long id) {
        return realtyRepository.getUsersIdById(id);
    }

    @Transactional
    @Override
    public Integer deleteUser(Long realtyId, Long userId) {
        return realtyUserRepository.deleteByRealtyIdAndUserId(realtyId, userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> getUserNamesById(Long id) {
        return realtyRepository.getUserNamesById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public RealtyUserDTO getAllRealtyUserDTO(Long realtyId, Long userId) {
        return realtyUserRepository.getAllDTO(realtyId, userId);
    }
}
