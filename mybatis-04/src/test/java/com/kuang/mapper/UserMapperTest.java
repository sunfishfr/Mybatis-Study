package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

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

    @Test
    public void testLog4J(){
        logger.debug("debug:进入了日志。");
        logger.info("info:进入了日志。");
        logger.error("error:进入了日志。");

    }
}
