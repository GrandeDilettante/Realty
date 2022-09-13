package com.realty.repository;

import com.realty.entity.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RealtyRepository extends JpaRepository<Realty,Long> {
    void deleteById(Optional<Realty> realty);

    Realty getReferenceById();
}
