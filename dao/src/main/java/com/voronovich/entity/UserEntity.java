package com.voronovich.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * POJO user entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "basketEntities")
@ToString(exclude = "basketEntities")
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getUsersByLoginAndPassword", query = UserEntity.QUERY_GET_USERS_BY_LOGIN_AND_PASSWORD),
        @NamedQuery(name = "getUsersByLogin", query = UserEntity.QUERY_GET_USERS_BY_LOGIN),
        @NamedQuery(name = "getUsersByEmail", query = UserEntity.QUERY_GET_USERS_BY_EMAIL),
        @NamedQuery(name = "getAllUsers", query = UserEntity.QUERY_GET_ALL_USERS),
})
public class UserEntity implements Serializable {

    static final String QUERY_GET_USERS_BY_LOGIN_AND_PASSWORD = "FROM UserEntity u WHERE u.login = :login and u.password = :password";
    static final String QUERY_GET_USERS_BY_LOGIN = "FROM UserEntity u WHERE u.login = :login";
    static final String QUERY_GET_USERS_BY_EMAIL = "FROM UserEntity u WHERE u.email = :email";
    static final String QUERY_GET_ALL_USERS = "FROM UserEntity";

    @Id
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "Name", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your name must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String name;
    @Column(name = "Surname", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your surname must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String surname;
    @Column(name = "Email", insertable = true, updatable = true)
    @Email
    private String email;
    @Column(name = "Login", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your login must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z0-9-_.]+")
    private String login;
    @Column(name = "Password", insertable = true, updatable = true)
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z0-9-_.]+")
    @Size(min = 3, max = 65, message = "Your password must be between 3 and 65 characters long.")
    private String password;
    @Column(name = "Salt", insertable = true, updatable = true)
    private String salt;
    @Column(name = "BlackList", insertable = true, updatable = true)
    private String blackList;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity roleEntity;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<BasketEntity> basketEntities = new ArrayList<>();
    @Column(name = "RegistrationDate", insertable = true, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public UserEntity(int idUser, String name, String surname, String email,
                      String login, String password, String salt, String blackList,
                      RoleEntity roleEntity, Date registrationDate) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.blackList = blackList;
        this.roleEntity = roleEntity;
        this.registrationDate = registrationDate;
    }
}