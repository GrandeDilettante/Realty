package com.realty.service.impl;

import com.realty.repository.RealtyRepository;
import com.realty.entity.Realty;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Realty> getById(Long id) {
        return realtyRepository.findById(id);
    }

    @Override
    public Realty save(Realty realty) {
        return realtyRepository.save(realty);
    }

    @Override
    public void deleteById(Long id) {
            realtyRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return realtyRepository.existsById(id);
    }
}
