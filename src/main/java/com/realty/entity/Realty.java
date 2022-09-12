package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(schema = "catalogs", name = "trealty")
public class Realty extends BaseEntity {
    private Long id;
    private String name;
    private Long price;
}
