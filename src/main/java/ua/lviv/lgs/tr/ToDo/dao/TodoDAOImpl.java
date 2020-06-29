package ua.lviv.lgs.tr.ToDo.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.tr.ToDo.domain.Todo;
import ua.lviv.lgs.tr.ToDo.mapper.TodoRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class TodoDAOImpl extends BaseDAO implements ua.lviv.lgs.tr.ToDo.dao.TodoDAO {

    @Override
    public void save(Todo todo) {
        String sql = "INSERT INTO todo (userId,month,day,year,title,description,priority) VALUES (:userId, :month, :day, :year, :title, :description, :priority)";
        Map m = new HashMap();
        m.put("userId", todo.getUserId());
        m.put("month", todo.getMonth());
        m.put("day", todo.getDay());
        m.put("year", todo.getYear());
        m.put("title", todo.getTitle());
        m.put("description", todo.getDescription());
        m.put("priority", todo.getPriority());

        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer todoId = kh.getKey().intValue();
        todo.setTodoId(todoId);

    }

    @Override
    public void update(Todo todo) {
        String sql = "UPDATE todo SET month=:month, day=:day, year=:year, title=:title, description=:description, priority=:priority  WHERE todoId=:todoId";
        Map m = new HashMap();
        m.put("todoId", todo.getTodoId());
        m.put("month", todo.getMonth());
        m.put("day", todo.getDay());
        m.put("year", todo.getYear());
        m.put("title", todo.getTitle());
        m.put("description", todo.getDescription());
        m.put("priority", todo.getPriority());

        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Todo todo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer todoId) {
        String sql = "DELETE FROM todo WHERE todoId=?";
        getJdbcTemplate().update(sql, todoId);
    }

    @Override
    public Todo findById(Integer todoId) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE todoId=?";
        return getJdbcTemplate().queryForObject(sql, new TodoRowMapper(), todoId);
    }

    @Override
    public List<Todo> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Todo> findByProperty(String propName, Object propValue) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), propValue);
    }

    @Override
    public List<Todo> orderByPriority(String propName, Object propValue) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE " + propName + "=? ORDER BY priority";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), propValue);
    }

}
