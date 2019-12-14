package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
     //查询所有用户
     List<User> getUserList();

     //根据ID查询
     User getUserById(int id);

     //insert用户
     int addUser(User user);

     //修改用户
     int updateUser(User user);

     //删除用户
     int deleteUserById(int id);
}
