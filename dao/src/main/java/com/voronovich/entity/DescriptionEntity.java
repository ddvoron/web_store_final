package com.voronovich.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Pojo - description role entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "description")
@NamedQueries({
        @NamedQuery(name = "getAllDescriptions",
                query = DescriptionEntity.QUERY_GET_ALL_DESCRIPTIONS),
        @NamedQuery(name = "getAllDescriptionsByData",
                query = DescriptionEntity.QUERY_GET_ALL_DESCRIPTIONS_BY_DATA),

})
public class DescriptionEntity implements Serializable{

    static final String QUERY_GET_ALL_DESCRIPTIONS
            = "FROM DescriptionEntity";
    static final String QUERY_GET_ALL_DESCRIPTIONS_BY_DATA
            = "FROM DescriptionEntity d WHERE d.dataEntity = :dataEntity";

    @Id
    @Column(name = "id_description")
    private int idDescription;
    @Column(name = "Title")
    private String title;
    @Column(name = "Value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "id_data")
    private DataEntity dataEntity;

    public DescriptionEntity(int idDescription, String title,
                             String value, DataEntity dataEntity) {
        this.idDescription = idDescription;
        this.title = title;
        this.value = value;
        this.dataEntity = dataEntity;
    }
}
