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
    @Insert("insert into user(user_id,username,password,email,role_id,valid) values(#{user_id},#{username},#{password},#{email},2,1)")
    int add(int user_id,String username,String password,String email);
    @Select("select password from user where username=#{uname} and valid=1 and username!='deleteduser'")
    String findPwdbyUsername(String uname);

    @Select("select max(user_id) from user")
    int findmaxUser_id();

    @Select("select permission_id,name,comment,path,icon from user natural join role_permission natural join permission where user_id=#{user_id}")
    @Results(id="permissionMap",value={
            @Result(property = "permission_id",column = "permission_id",javaType = Integer.class),
            @Result(property = "name",column = "name",javaType = String.class),
            @Result(property = "comment",column = "comment"),
            @Result(property = "path",column = "path"),
            @Result(property = "icon",column = "icon")
    })
    List<Permission> findPermisssion(int user_id);
    @Select("select user_id,username,password,email,role_id from user where username=#{uname}")
    @Results(id="userMap",value={
            @Result(property = "user_id",column = "user_id",javaType = Integer.class),
            @Result(property = "userName",column = "username",javaType = String.class),
            @Result(property = "password",column = "password",javaType = String.class),
            @Result(property = "email",column = "email",javaType = String.class),
            @Result(property = "role",column = "role_id",javaType = Integer.class)
    })
    MyUser findUserbyUsername(String uname);

    @Select("select user_id,username,password,email,role_id from user where valid=1")
    @Results(id="allUserMap",value={
            @Result(property = "user_id",column = "user_id",javaType = Integer.class),
            @Result(property = "userName",column = "username",javaType = String.class),
            @Result(property = "password",column = "password",javaType = String.class),
            @Result(property = "email",column = "email",javaType = String.class),
            @Result(property = "role",column = "role_id",javaType = Integer.class)
    })
    List<MyUser> findallUser();

    @Update("update user set username='deleteduser',valid=0 where user_id=#{user_id}")
    int deleteUser(int user_id);

    @Update("update user set role_id=#{role_id} where user_id=#{user_id}")
    int changeUserRole(int user_id,int role_id);

    //@Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    //int update(Student student);

    //@Delete("delete from  where ")
    //int deleteBysno(String sno);
}
