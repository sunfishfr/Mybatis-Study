package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //根据ID查询
    User getUserById(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

}
