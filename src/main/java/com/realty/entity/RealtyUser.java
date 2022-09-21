package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "catalogs", name = "trealty_users")
@Data
public class RealtyUser extends BaseEntity {

    @Column(name = "realty_id")
    private Long realtyId;

    @Column(name = "user_id")
    private Long userId;
}
