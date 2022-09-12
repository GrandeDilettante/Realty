package com.realty.controller;

import com.realty.entity.Realty;
import com.realty.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class RealtyController {

    private final RealtyService realtyService;

    @Autowired
    public RealtyController(RealtyService realtyService) {
        this.realtyService = realtyService;
    }

    @GetMapping
    public ResponseEntity<?> getAllRealty(Integer pageNum, Integer pageSize) {

        if (pageNum != null && pageNum > -1 && pageSize != null && pageSize > 0) {
            Pageable pageable = PageRequest.of(pageNum, pageSize);
            return ResponseEntity.ok().body(realtyService.getAll(pageable));
        }
        return ResponseEntity.ok().body(realtyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRealty(@PathVariable final Long id) {
        try {
            return ResponseEntity.ok().body(realtyService.getById(id));
        } catch (Exception e) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addRealty(@RequestBody final Realty realty) {
        try {
            realtyService.save(realty);
            return new ResponseEntity<>("Данный обьект успешно добавлен ", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось добавить данный обьект", BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateRealty(@RequestBody final  Realty realty) {
        if(!realtyService.existsById(realty.getId())) {
            return new ResponseEntity<>("Данный обьект не найден ", NOT_FOUND);
        }
        try {
            realtyService.save(realty);
            return new ResponseEntity<>("Данный обьект успешно обновлен ", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось обновить данный обьект", BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRealty(@PathVariable final Long id){
        try {
            realtyService.deleteById(id);
            return new ResponseEntity<>("Данный обьект успешно удален ", NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Не удалось удалить данный обьект", BAD_REQUEST);
        }
    }
}
