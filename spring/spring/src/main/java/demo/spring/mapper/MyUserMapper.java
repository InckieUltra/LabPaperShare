package demo.spring.mapper;

import demo.spring.entity.MyUser;
import demo.spring.entity.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper
public interface MyUserMapper {
    @Insert("insert into user(user_id,username,password) values(#{user_id},#{username},#{password})")
    int add(int user_id,String username,String password);
    @Select("select password from user where username=#{uname}")
    String findPwdbyUsername(String uname);

    @Select("select max(user_id) from user")
    int findmaxUser_id();

    @Select("select permission_id,name,comment,path,icon from user_role natural join role_permission natural join permission where user_id=#{user_id}")
    @Results(id="permissionMap",value={
            @Result(property = "permission_id",column = "permission_id",javaType = Integer.class),
            @Result(property = "name",column = "name",javaType = String.class),
            @Result(property = "comment",column = "comment"),
            @Result(property = "path",column = "path"),
            @Result(property = "icon",column = "icon")
    })
    List<Permission> findPermisssion(int user_id);
    @Select("select user_id,username,password from user where username=#{uname}")
    @Results(id="userMap",value={
            @Result(property = "user_id",column = "user_id",javaType = Integer.class),
            @Result(property = "userName",column = "username",javaType = String.class),
            @Result(property = "password",column = "password",javaType = String.class)
    })
    MyUser findUserbyUsername(String uname);

    //@Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    //int update(Student student);

    //@Delete("delete from  where ")
    //int deleteBysno(String sno);
}