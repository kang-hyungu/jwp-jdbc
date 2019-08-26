package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapping(ResultSet resultSet) throws SQLException;
}
