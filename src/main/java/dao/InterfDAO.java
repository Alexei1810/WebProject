package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InterfDAO {
    Connection connection();
    PreparedStatement insert() throws SQLException;
    ResultSet selectAll() throws SQLException;
    PreparedStatement update() throws  SQLException;
    PreparedStatement delete() throws SQLException;
    PreparedStatement selectOne();
}
