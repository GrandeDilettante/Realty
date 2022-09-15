package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "catalogs", name = "tbid")
public class Bid extends BaseEntity {
    private Date createTime;
    private Double value;
    private Long realtyId;

//    @JoinColumn(name = "realty_id", updatable = false)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @ManyToOne(targetEntity = Realty.class, fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Realty realty;
}
