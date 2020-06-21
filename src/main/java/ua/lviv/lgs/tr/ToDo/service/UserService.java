package ua.lviv.lgs.tr.ToDo.service;

import ua.lviv.lgs.tr.ToDo.domain.Todo;
import ua.lviv.lgs.tr.ToDo.domain.User;

public interface UserService {
    void register(User u);

    User login(String loginName, String password);

    void saveTodo(Todo t);

}
