package com.realty.service.impl;

import com.realty.dao.RealtyRepository;
import com.realty.entity.Realty;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

public class RealtyServiceImpl implements RealtyService {

    private RealtyRepository realtyRepository;

    @Autowired
    public RealtyServiceImpl(RealtyRepository realtyRepository) {
        this.realtyRepository = realtyRepository;
    }

    @Override
    public List<Realty> getAll(Pageable pageable) {
        return realtyRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    @Override
    public Realty getById(Long id) {
        Optional<Realty> realty = realtyRepository.findById(id);
        if(!realty.isEmpty()) {
            return realty.get();
        } else
            throw new NotFoundException("Not found");
    }

    @Override
    public Realty save(Realty realty) {
        return realtyRepository.save(realty);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Realty> realty = realtyRepository.findById(id);
        if(realty.isPresent()) {
            realtyRepository.deleteById(realty);
        } else
            throw new NotFoundException("Not found");
    }

    @Override
    public boolean existsById(Long id) {
        return realtyRepository.existsById(id);
    }
}
