package com.etc.mybatis.test;

import com.etc.mybatis.dao.UserDao;
import com.etc.mybatis.dao.UserDaoImpl;
import com.etc.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
public class MyTest02 {
    private SqlSessionFactory factory;

    @Before
    public void set() throws IOException {
        String rs="SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(rs);

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(is);

    }
    @Test
    public void selectByUserName(){
        UserDao userDao=new UserDaoImpl(factory);
        User user=userDao.findByUserName("lily");
        System.out.println(user.toString());
    }
    @Test
    public void selectAllUser(){
        UserDao userDao=new UserDaoImpl(factory);
        List<User> users=userDao.findAllUser();
        System.out.println(users);
    }
    @Test
    public void insertUser(){
        UserDao userDao=new UserDaoImpl(factory);
        User user=new User();
        user.setUsername("大涛");
        user.setPassword("123");
        int i= userDao.insertUser(user);

    }
    @Test
    public void updateUser(){
        UserDao userDao=new UserDaoImpl(factory);
        User user=new User();
        user.setUsername("模3式");
        user.setPassword("123");
        int i= userDao.updateUser(user);

    }
    @Test
    public void deleteUser(){
        UserDao userDao=new UserDaoImpl(factory);
        User user=new User();
        user.setId(19);
        int i= userDao.deleteUser(user);

    }
}
