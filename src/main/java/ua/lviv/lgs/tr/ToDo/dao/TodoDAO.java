package ua.lviv.lgs.tr.ToDo.dao;

import ua.lviv.lgs.tr.ToDo.domain.Todo;

import java.util.List;


public interface TodoDAO {

    void save(Todo todo);

    void update(Todo todo);

    void delete(Todo todo);

    void delete(Integer todoId);

    Todo findById(Integer todoId);

    List<Todo> findAll();

    List<Todo> findByProperty(String propName, Object propValue);

    List<Todo> orderByPriority(String propName, Object propValue);

}
