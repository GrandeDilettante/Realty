package com.realty.entity;

import com.realty.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            schema = "catalogs",
            name = "trealty_users",
            joinColumns = @JoinColumn(name = "realty_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(schema = "catalogs", name = "trealty_users",
            joinColumns = @JoinColumn(name = "realty_id"))
    @Column(name = "user_id")
    private Set<Long> usersId;
}
