package dao;

import java.sql.*;

public class ClassDAO implements InterfDAO {
    Connection connection=connection();
    @Override
    public Connection connection() {
        final String URL="jdbc:mysql://localhost:3306/webservice?serverTimezone=Europe/Minsk&useSSL=false";
        final String USER="root";
        final  String PASSWORD="1234";
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public PreparedStatement insert() throws SQLException {
        final String INSERT="insert into user(name, password) values(?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT);
            return preparedStatement;
    }

    @Override
    public ResultSet selectAll() {
        final String SELECT="select * from user;";
        PreparedStatement preparedStatement= null;
        ResultSet resultSet=null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public PreparedStatement selectOne() {
        final String SELECT="select * from user where name=?";
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public PreparedStatement update() throws SQLException {
        final String UPDATE="update user set name=?, password=? where id=?;";
        PreparedStatement preparedStatement=connection.prepareStatement(UPDATE);
        return preparedStatement;
    }

    @Override
    public PreparedStatement delete() throws SQLException {
        final String DELETE="delete from user where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
        return preparedStatement;
    }
}
