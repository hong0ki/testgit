package com.etc.mybatis.dao;

import com.etc.mybatis.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
public interface UserDao {
    User findByUserName(String username);

    List<User> findAllUser();

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);
}
