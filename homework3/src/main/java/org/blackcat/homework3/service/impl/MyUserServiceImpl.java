package org.blackcat.homework3.service.impl;

import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.blackcat.homework3.entity.MyUser;
import org.blackcat.homework3.mapper.MyUserMapper;
import org.blackcat.homework3.service.MyUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
    @Resource
    private MyUserMapper myUserMapper;
    @Override
    public List<MyUser> findAll() {
        return myUserMapper.findAll();
    }

    @Override
    public MyUser finUserByName(String username) {
        return myUserMapper.findUserByName(username);
    }

    @Override
    public void deleteByUserName(String username) {
        myUserMapper.deleteByUserName(username);
    }

    @Override
    public void deleteById(Integer id) {
        myUserMapper.deleteById(id);
    }

    @Override
    public MyUser finUserById(Integer id) {
        return myUserMapper.findUserById(id);
    }

    @Override
    public void update(String username, String password,int id) {
        myUserMapper.update(username,password,id);
    }

    @Override
    public void register(String username, String password) {
        myUserMapper.register(username,password);
    }
}
