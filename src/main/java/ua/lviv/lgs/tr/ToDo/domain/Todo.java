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
@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue
    private Integer todoId;
    private Integer userId;

    @Column(name = "day", nullable = false)
    private String day;
    @Column(name = "month", nullable = false)
    private String month;
    @Column(name = "year", nullable = false)
    private String year;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "priority", nullable = false)
    private String priority;

}

