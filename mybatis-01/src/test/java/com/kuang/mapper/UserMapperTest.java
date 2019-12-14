package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        //1.获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.遍历
        List<User> users =  userMapper.getUserList();
        for (User user : users) {
            System.out.println(user.toString());
        }
        //4.关闭
        sqlSession.close();
    }
}
