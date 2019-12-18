package com.kuang.mapper;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int insertUser( User user);

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUserById(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(@Param("id") int id);
}
