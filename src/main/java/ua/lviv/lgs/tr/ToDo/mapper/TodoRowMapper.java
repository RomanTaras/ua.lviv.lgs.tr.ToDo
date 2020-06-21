package ua.lviv.lgs.tr.ToDo.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.lviv.lgs.tr.ToDo.domain.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int i) throws SQLException {
        Todo t = new Todo();
        t.setTodoId(rs.getInt("todoId"));
        t.setUserId(rs.getInt("userId"));
        t.setMonth(rs.getString("month"));
        t.setDay(rs.getString("day"));
        t.setYear(rs.getString("year"));
        t.setTitle(rs.getString("title"));
        t.setDescription(rs.getString("description"));
        t.setPriority(rs.getString("priority"));
        return t;

    }

}
