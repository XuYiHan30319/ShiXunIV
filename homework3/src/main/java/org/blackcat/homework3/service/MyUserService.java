package org.blackcat.homework3.service;

import org.blackcat.homework3.entity.MyUser;

import java.util.List;

public interface MyUserService {
    public List<MyUser> findAll();

    public void register(String username,String password);

    public MyUser finUserByName(String username);

    void deleteByUserName(String username);

    void deleteById(Integer id);

    MyUser finUserById(Integer id);

    void update(String username, String password,int id);
}
