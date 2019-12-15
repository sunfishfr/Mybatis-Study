package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void getUserList() {
        //1.获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.执行Sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.遍历
        List<User> users = userMapper.getUserList();
        for (User user : users) {
            System.out.println(user.toString());
        }
        //4.关闭
        sqlSession.close();
    }

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
    public void addUser() {
        //1.获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(5, "婉如", "666");
        int result = userMapper.addUser(user);
        if (result > 0) {
            System.out.println("插入成功！名字：" + user.getName());
        }
        //提交事务
        sqlSession.commit();
        //4.关闭
        sqlSession.close();
    }

    @Test
    public void addUserByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("id", 5);
        map.put("username", "小丽");
        map.put("password", "77885566");

        int result = userMapper.addUserByMap(map);

        if (result > 0) {
            System.out.println("新增成功！账号：" + map.get("username"));
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "鲁小韩", "777111");
        int result = userMapper.updateUser(user);
        if (result > 0) {
            System.out.println("修改成功，id = " + user.getId());
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUserPassword() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        int id = 2;
        map.put("id", id);
        map.put("password", "666666");
        int result = userMapper.updateUserPassword(map);

        if (result > 0) {
            System.out.println("修改成功，id = " + id);
        }
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int id = 5;
        int result = userMapper.deleteUserById(id);
        if (result > 0) {
            System.out.println("删除成功！ id = " + id);
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
