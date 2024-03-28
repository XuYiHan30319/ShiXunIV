package org.blackcat.homework3.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.blackcat.homework3.entity.MyUser;

import java.util.List;

@Mapper
public interface MyUserMapper {
    @Select("select * from myuser")
    List<MyUser> findAll();

    @Select("select * from myuser where username=#{username}")
    MyUser findUserByName(String username);

    @Insert("insert into myuser(username,password) values(#{username},#{password})")
    void register(String username, String password);

    @Delete("delete from myuser where username=#{username}")
    void deleteByUserName(String username);

    @Delete("delete from myuser where id=#{id}")
    void deleteById(Integer id);

    @Select("select * from myuser where id=#{id}")
    MyUser findUserById(int id);

    @Update("update myuser set username = #{username}, password = #{password} where id = #{id}")
    void update(String username, String password, int id);
}
