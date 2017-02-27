package com.voronovich.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo - catalog entity
 *
 * @author  Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "dataEntities")
@ToString(exclude = "dataEntities")
@Entity
@Table(name = "catalog")
@NamedQueries({
        @NamedQuery(name = "getAllDepartments",
                query = CatalogEntity.QUERY_GET_ALL_DEPARTMENTS),
})
public class CatalogEntity implements Serializable{

    static final String QUERY_GET_ALL_DEPARTMENTS = "FROM CatalogEntity";

    @Id
    @Column(name = "id_catalog")
    private int idCatalog;
    @Column(name = "Department")
    private String department;
    @JsonIgnore
    @OneToMany(mappedBy = "catalogEntity", cascade = CascadeType.ALL)
    private List<DataEntity> dataEntities = new ArrayList<>();

    public CatalogEntity(int idCatalog, String department) {
        this.idCatalog = idCatalog;
        this.department = department;
    }
}
