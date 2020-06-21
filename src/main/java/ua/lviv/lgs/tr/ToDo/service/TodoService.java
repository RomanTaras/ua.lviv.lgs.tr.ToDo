package ua.lviv.lgs.tr.ToDo.service;

import ua.lviv.lgs.tr.ToDo.domain.Todo;

import java.util.List;


public interface TodoService {

    void save(Todo t);

    void update(Todo t);

    void delete(Integer todoId);

    Todo findById(Integer todoId);

    List<Todo> findUserTodo(Integer userId);

    List<Todo> findByPriority(Integer userId);

    List<Todo> findUserTodo(Integer userId, String txt);

    List<Todo> findUserTodoOnlyHigh(Integer userId);

    List<Todo> findUserTodoOnlyMedium(Integer userId);

    List<Todo> findUserTodoOnlyLow(Integer userId);

}
