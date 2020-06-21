package ua.lviv.lgs.tr.ToDo.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.tr.ToDo.domain.User;

import java.util.HashMap;
import java.util.Map;


@Repository
public class UserDAOImpl extends BaseDAO implements ua.lviv.lgs.tr.ToDo.dao.UserDAO {

    @Override
    public void save(User u) {
        String sql = "INSERT INTO USER(name,phone,password,loginName)"
                + "VALUES(:name,:password,:phone,:loginName)";
        Map<String, String> m = new HashMap<>();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("password", u.getPassword());
        m.put("loginName", u.getLoginName());


        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);

    }

    @Override
    public void update(User u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
