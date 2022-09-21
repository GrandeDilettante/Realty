package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "catalogs", name = "users")
@Data
public class User extends BaseEntity {

    private String name;
}
