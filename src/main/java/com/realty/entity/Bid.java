package com.realty.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realty.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = "realty")
@Table(schema = "catalogs", name = "tbid")
public class Bid extends BaseEntity {

    @CreationTimestamp
    @Column(name = "createdate")
    private Date createDate;
    private Double value;

//    @JoinColumn(name = "realty_id", updatable = false)
//    @ManyToOne
//    @JsonIgnore
//    private Realty realty;

    @Column(name = "realty_id")
    private Long realtyId;
}
