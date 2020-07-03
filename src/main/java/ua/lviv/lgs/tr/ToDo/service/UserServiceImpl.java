package ua.lviv.lgs.tr.ToDo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.tr.ToDo.dao.BaseDAO;
import ua.lviv.lgs.tr.ToDo.dao.TodoDAO;
import ua.lviv.lgs.tr.ToDo.dao.UserDAO;
import ua.lviv.lgs.tr.ToDo.domain.Todo;
import ua.lviv.lgs.tr.ToDo.domain.User;
import ua.lviv.lgs.tr.ToDo.mapper.UserRowMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseDAO implements ua.lviv.lgs.tr.ToDo.service.UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private TodoDAO todoDao;

    @Override
    public void register(User u) {
        userDao.save(u);
    }

    @Override
    public User login(String login_name, String password) {

        String sql = "SELECT userid, name, phone,login_name FROM user WHERE login_name=:ln AND password=:pw";

        Map m = new HashMap();
        m.put("ln", login_name);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            return u;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void saveTodo(Todo t) {
        todoDao.save(t);
    }

}

