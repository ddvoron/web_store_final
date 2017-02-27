package com.voronovich.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pojo - data entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"basketEntities", "descriptionEntities"})
@ToString(exclude = {"basketEntities", "descriptionEntities"})
@Entity
@Table(name = "data")
@NamedQueries({
        @NamedQuery(name = "getAllData", query = DataEntity.QUERY_GET_ALL_DATA),
})
public class DataEntity implements Serializable {

    static final String QUERY_GET_ALL_DATA = "FROM DataEntity ";

    @Id
    @Column(name = "id_data")
    private int idData;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column(name = "Price")
    private float price;
    @Column(name = "ReleaseDate")
    private String releaseDate;
    @Column(name = "Picture")
    private String picture;
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "Creator")
    private String creator;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "Updater")
    private String updater;
    @ManyToOne
    @JoinColumn(name = "id_catalog")
    private CatalogEntity catalogEntity;
    @JsonIgnore
    @OneToMany(mappedBy = "dataEntity", cascade = CascadeType.REMOVE)
    private List<BasketEntity> basketEntities = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "dataEntity", cascade = CascadeType.REMOVE)
    private List<DescriptionEntity> descriptionEntities = new ArrayList<>();

    public DataEntity(int idData, String brand, String model, float price,
                      String releaseDate, String picture, Date creationDate,
                      String creator, Date updateDate, String updater,
                      CatalogEntity catalogEntity) {
        this.idData = idData;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseDate = releaseDate;
        this.picture = picture;
        this.creationDate = creationDate;
        this.creator = creator;
        this.creationDate = updateDate;
        this.updater = updater;
        this.catalogEntity = catalogEntity;
    }
}
