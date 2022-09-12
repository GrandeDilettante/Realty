package com.realty.service;

import com.realty.entity.Realty;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RealtyService {

    List<Realty> getAll(Pageable pageable);
    List<Realty> getAll();

    Realty save(Realty realty);

    Realty getById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);


}
