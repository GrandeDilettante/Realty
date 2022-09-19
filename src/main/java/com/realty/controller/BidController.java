package com.realty.controller;

import com.realty.entity.Bid;
import com.realty.service.BidService;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;
    private final RealtyService realtyService;

    @Autowired
    public BidController(BidService bidService, RealtyService realtyService) {
        this.bidService = bidService;
        this.realtyService = realtyService;
    }

    @GetMapping
    public List getAll(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize) {

        if (pageNum != null && pageNum > -1 && pageSize != null && pageSize > 0) {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            return bidService.getAll(pageable);
        }
        return bidService.getAll();
    }

    @GetMapping("/realty/{realtyId}")
    public List getAllByRealtyId(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize,
            @PathVariable(required = false) Long realtyId) {
        if (bidService.existsById(realtyId)) {
            if (pageNum != null && pageNum > -1 && pageSize != null && pageSize > 0) {
                Pageable pageable = PageRequest.of(pageNum, pageSize);
                return bidService.getAllByRealtyId(pageable, realtyId);
            }
        }
        return bidService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id) {
        if (!bidService.existsById(id)) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        } else
            return ResponseEntity.ok().body(bidService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Bid bid) {
        try {
            bidService.save(bid);
            return new ResponseEntity<>("Данный обьект успешно добавлен ", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось добавить данный обьект ", BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody final Bid bid) {
        if (!bidService.existsById(bid.getId())) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        }
        try {
            bidService.save(bid);
            return new ResponseEntity<>("Данный обьект успешно добавлен ", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось добавить данный обьект ", BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id) {
        try {
            bidService.deleteById(id);
            return new ResponseEntity<>("Данный обьект успешно удален", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить обьект ", BAD_REQUEST);
        }
    }
}
