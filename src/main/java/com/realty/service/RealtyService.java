package com.realty.service;

import com.realty.entity.Realty;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface RealtyService {

    List<Realty> getAll(Pageable pageable);
    List<Realty> getAll();

    Realty save(Realty realty);

    Optional<Realty> getById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);


}
