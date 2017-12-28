package com.etc.mybatis.test;

import com.etc.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/12/27.
 */
public class MyTest {
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    @Before
    public void set() throws IOException {
        String rs="SqlMapConfig.xml";
        InputStream  is = Resources.getResourceAsStream(rs);

        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(is);

    }
    @Test
    public void addTest(){

        sqlSession=factory.openSession();
        User user=new User();
        user.setPassword("jj0j");
        user.setUsername("模式");
        sqlSession.insert("test.insertByUser",user);

        System.out.println(user.toString());


    }
    @Test
    public void queryTest(){
        sqlSession=factory.openSession();
        User user=sqlSession.selectOne("test.selectByUserName","模3式");
        System.out.println(user.toString());

    }
    @Test
    public void updataTest(){
        sqlSession=factory.openSession();
        User user=new User();
        user.setUsername("模3式");
        user.setPassword("llll");
        sqlSession.update("test.updateByUserName",user);
    }
    @Test
    public void deleteTest(){
        sqlSession=factory.openSession();
        User user=new User();
        user.setId(12);
        sqlSession.delete("test.deleteById",user);


    }
    @After
    public void commitAndClose(){
        sqlSession.commit();
        sqlSession.close();
    }
}
