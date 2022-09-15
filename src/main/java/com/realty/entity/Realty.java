package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "catalogs", name = "trealty")
public class Realty extends BaseEntity {
    private String name;
    private Long price;

//    @NotFound(action = NotFoundAction.IGNORE)
//    @OneToMany
//    @JoinColumn(name = "realty_id")
//    private Set<Bid> bid;
}
