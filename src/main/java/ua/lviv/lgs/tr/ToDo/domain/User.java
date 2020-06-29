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
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "userID", nullable = false)
    private Integer userId;


    @Column()
    private String login_name;

    @Column
    private String loginStatus;

    @Column
    private String name;


    @Column
    private String password;

    @Column
    private String phone;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", loginName='" + login_name + '\'' +
                ", password='" + password + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                '}';
    }
}
