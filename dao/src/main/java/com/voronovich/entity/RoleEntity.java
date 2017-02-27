package com.voronovich.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo - users role entity
 *
 * @author  Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"idRole","name"})
@ToString(exclude = "userEntities")
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries({
        @NamedQuery(name = "getAllRoles", query = RoleEntity.QUERY_GET_ALL_ROLES),
})
public class RoleEntity implements Serializable {

    static final String QUERY_GET_ALL_ROLES = "FROM RoleEntity";

    @Id
    @Column(name = "id_role")
    private int idRole;
    @Column(name = "Name", insertable = true, updatable = true)
    private String name;
    @OneToMany(mappedBy = "roleEntity", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities = new ArrayList<>();

    public RoleEntity(int idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }
}


