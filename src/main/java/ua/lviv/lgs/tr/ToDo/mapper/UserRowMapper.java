package ua.lviv.lgs.tr.ToDo.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.lviv.lgs.tr.ToDo.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setLoginName(rs.getString("loginName"));

        return u;
    }

}
