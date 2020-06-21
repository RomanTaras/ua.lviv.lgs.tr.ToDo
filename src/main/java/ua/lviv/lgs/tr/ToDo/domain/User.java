package ua.lviv.lgs.tr.ToDo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "User")
public class User {


    @Id
    @GeneratedValue
    private Integer userId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "loginName", nullable = false)
    private String loginName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "loginStatus", nullable = false)
    private String loginStatus;

}
