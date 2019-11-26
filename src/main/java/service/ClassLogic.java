package service;

import dao.ClassDAO;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassLogic {
    Scanner scanner=new Scanner(System.in);
    ClassDAO classDAO=new ClassDAO();
    public User toMyPage(User user){
        User userInfo=new User();
        if(login(user)) {
            userInfo = getInfo(user.getName());
        }
       return userInfo;
    }

    public boolean login(User user){
        boolean flag=false;
        ResultSet resultSet=classDAO.selectAll();
        ArrayList<User> users=new ArrayList<User>();
        try{
            while (resultSet.next()){
               User user1=new User(resultSet.getString("name"),
                       resultSet.getString("password"));
               users.add(user1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        for(int i=0;i<users.size();i++){
            if(user.getName().equals(users.get(i).getName())&&
            user.getPassword().equals(users.get(i).getPassword())){
                flag=true;
            }
        }
        return flag;
    }
    public User getInfo(String name){
        User user=new User();
        PreparedStatement preparedStatement=classDAO.selectOne();
        try {
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }
    public boolean createUser(User user){
        boolean flag=true;
        try {
            ArrayList<User> users=new ArrayList<User>();
            ResultSet resultSet=classDAO.selectAll();
            while (resultSet.next()){
                User userDB=new User();
                userDB.setName(resultSet.getString("name"));
                users.add(userDB);
            }
            for(int i=0;i<users.size();i++){
                if(user.getName().equals(users.get(i).getName())){
                    flag=false;
                }
            }
            if(flag) {
                PreparedStatement preparedStatement = classDAO.insert();
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.execute();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public ArrayList<User> showUsers(){
        ArrayList<User> users=new ArrayList<User>();
        try {
            ResultSet resultSet=classDAO.selectAll();
            while(resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
               user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
//            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void updateUser(User user){
        try {
            PreparedStatement preparedStatement=classDAO.update();
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = classDAO.delete();
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
