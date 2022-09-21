package com.realty.service.impl;

import com.realty.entity.Bid;
import com.realty.repository.BidRepository;
import com.realty.repository.RealtyRepository;
import com.realty.entity.Realty;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RealtyServiceImpl implements RealtyService {

    private final RealtyRepository realtyRepository;
    private final BidRepository bidRepository;

    @Autowired
    public RealtyServiceImpl(RealtyRepository realtyRepository, BidRepository bidRepository) {
        this.realtyRepository = realtyRepository;
        this.bidRepository = bidRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List<Bid> getAllByRealtyId(Long realtyId) { return bidRepository.findAllByRealtyId(realtyId); }

    @Transactional
    @Override
    public Realty save(Realty realty) { return realtyRepository.save(realty); }

    @Transactional
    @Override
    public void deleteById(Long id) { realtyRepository.deleteById(id); }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Long id) { return realtyRepository.existsById(id); }
}
