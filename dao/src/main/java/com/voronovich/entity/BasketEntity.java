package com.voronovich.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Pojo - basket entity
 *
 * @author  Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "basket")
@NamedQueries({
        @NamedQuery(name = "getOrdersByUser", query = BasketEntity.QUERY_GET_ORDERS_BY_USER),
        @NamedQuery(name = "getOrdersByData", query = BasketEntity.QUERY_GET_ORDERS_BY_DATA),
        @NamedQuery(name = "getAllOrders", query = BasketEntity.QUERY_GET_ALL_ORDERS),
})
public class BasketEntity implements Serializable{

    static final String QUERY_GET_ORDERS_BY_USER = "FROM BasketEntity b WHERE b.userEntity = :userEntity";
    static final String QUERY_GET_ORDERS_BY_DATA = "FROM BasketEntity b WHERE b.dataEntity = :dataEntity";
    static final String QUERY_GET_ALL_ORDERS = "FROM BasketEntity";

    @Id
    @Column(name = "id_basket")
    private int idBasket;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "id_data")
    private DataEntity dataEntity;

    public BasketEntity(int idBasket, UserEntity userEntity, DataEntity dataEntity) {
        this.idBasket = idBasket;
        this.userEntity = userEntity;
        this.dataEntity = dataEntity;
    }
}
