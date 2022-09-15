package com.realty.service;

import com.realty.entity.Bid;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BidService {


    List<Bid> getAll(Pageable pageable);
    List<Bid> getAll();
    List<Bid> getAllByRealtyId(Long realtyId);

    Bid getById(Long id);

    Bid save(Bid bid);

    void deleteById(Long id);

    boolean existsById(Long id);

}
