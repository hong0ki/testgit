package com.etc.mybatis.dao;

import com.etc.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    private UserDao userDao;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;

    }

    @Override
    public User findByUserName(String username ){
        SqlSession sqlSession=factory.openSession();
        User user=sqlSession.selectOne("com.etc.mybatis.dao.UserDaoImpl.selectByUserName",username);
        sqlSession.commit();
        sqlSession.close();
        return user;

    }
    @Override
    public List<User> findAllUser(){
        SqlSession sqlSession=factory.openSession();
        List<User> users=sqlSession.selectList("com.etc.mybatis.dao.UserDaoImpl.selectAllUser");
        sqlSession.commit();
        sqlSession.close();
        return users;

    }
    @Override
    public int  insertUser(User user){
        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.insert("com.etc.mybatis.dao.UserDaoImpl.insertByUser",user);
        sqlSession.commit();
        sqlSession.close();
        return i;

    }
    @Override
    public int  updateUser(User user){
        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.update("com.etc.mybatis.dao.UserDaoImpl.updateByUserName",user);
        sqlSession.commit();
        sqlSession.close();
        return i;

    }
    @Override
    public int  deleteUser(User user){
        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.update("com.etc.mybatis.dao.UserDaoImpl.deleteById",user);
        sqlSession.commit();
        sqlSession.close();
        return i;

    }

}
