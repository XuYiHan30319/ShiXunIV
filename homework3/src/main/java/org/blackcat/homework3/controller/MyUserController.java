package org.blackcat.homework3.controller;

import jakarta.annotation.Resource;
import org.apache.ibatis.jdbc.Null;
import org.blackcat.homework3.entity.MyUser;
import org.blackcat.homework3.entity.Result;
import org.blackcat.homework3.service.MyUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class MyUserController {
    @Resource
    private MyUserService myUserService;

    @CrossOrigin("*")
    @GetMapping("/findAll")
    public Result findAll(){
        //查找全部的用户
        List<MyUser> users = myUserService.findAll();
        return Result.success(users);
    }

    @CrossOrigin("*")
    @PostMapping("/update")
    public Result update(@RequestBody  MyUser user){
        MyUser user1 = myUserService.finUserById(user.getId());
        if(user1==null){
            return Result.error("该用户不存在");
        }
        myUserService.update(user.getUsername(),user.getPassword(),user.getId());
        return Result.success();
    }

    @CrossOrigin("*")
    @PostMapping("/register")
    public Result register(@RequestBody  MyUser user){
        //注册用户
        MyUser user1 = myUserService.finUserByName(user.getUsername());
        if(user1!= null){
            return Result.error("该用户名已被注册");
        }
        myUserService.register(user.getUsername(),user.getPassword());
        return Result.success();
    }

    @CrossOrigin("*")
    @DeleteMapping("/delete")
    public Result delete(@RequestParam String username){
        //删除用户
        MyUser user1 = myUserService.finUserByName(username);
        if(user1 == null){
            return Result.error("该用户不存在");
        }
        myUserService.deleteByUserName(username);
        return Result.success();
    }
}
