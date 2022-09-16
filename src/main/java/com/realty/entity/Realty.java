package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "catalogs", name = "trealty")
public class Realty extends BaseEntity {

    private String name;
    private Long price;

//    @OneToMany(mappedBy = "realty")
//    private Set<Bid> bid;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "realty_id")
    private Set<Bid> bids;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinTable(schema = "catalogs", name = "tbid", joinColumns = @JoinColumn(name = "realty_id"))
//    @Column(name = "id")
//    private Set<Long> bidIds;
}
