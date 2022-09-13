package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(schema = "catalogs", name = "trealty")
public class Realty extends BaseEntity {
    private String name;
    private Long price;
}
