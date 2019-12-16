package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void getUserById() {
        //1.获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);

        System.out.println(user);
        //4.关闭
        sqlSession.close();
    }


}
