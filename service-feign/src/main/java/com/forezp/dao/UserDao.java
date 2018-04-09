package com.forezp.dao;


import com.forezp.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAllUsers();
}