package com.realty.controller;

import com.realty.entity.Bid;
import com.realty.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bid")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize) {

        if (pageNum != null && pageNum > -1 && pageSize != null && pageSize > 0) {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            return ResponseEntity.ok().body(bidService.getAll(pageable));
        }
        return ResponseEntity.ok().body(bidService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id) {
        if (!bidService.existsById(id)) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        } else
            return ResponseEntity.ok().body(bidService.getById(id));
    }

    @GetMapping("/realtyId/{realtyId}")
    public ResponseEntity<?> getAllByRealtyId(@PathVariable final Long realtyId) {
        if (!bidService.existsById(realtyId)) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        } else
            return ResponseEntity.ok().body(bidService.getAllByRealtyId(realtyId));
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
        } else
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
