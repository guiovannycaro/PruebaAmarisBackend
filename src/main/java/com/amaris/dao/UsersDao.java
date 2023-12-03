package com.amaris.dao;

import java.sql.SQLException;
import java.util.List;

import com.amaris.models.Users;
public  interface  UsersDao {

	String agregarUser(Users empl) throws SQLException ;
    List<Users> returnAllUsers() throws SQLException;
    String updateUser(Users empl) throws SQLException ;
    List<Users> buscarUserById(Users datos) throws SQLException;
   
}
