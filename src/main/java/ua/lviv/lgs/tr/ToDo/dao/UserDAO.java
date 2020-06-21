package ua.lviv.lgs.tr.ToDo.dao;

import ua.lviv.lgs.tr.ToDo.domain.User;

public interface UserDAO {

    void save(User u);

    void update(User u);
}
