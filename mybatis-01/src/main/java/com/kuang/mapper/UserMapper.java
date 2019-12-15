package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
     //查询所有用户
     List<User> getUserList();

     //根据ID查询
     User getUserById(int id);

     //insert用户
     int addUser(User user);

     //insert用户
     int addUserByMap(Map<String,Object> map);

     //修改用户
     int updateUser(User user);

     //修改用户2
     int updateUserPassword(Map<String,Object> map);

     //删除用户
     int deleteUserById(int id);
}
