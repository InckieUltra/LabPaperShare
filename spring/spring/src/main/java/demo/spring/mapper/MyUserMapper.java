package demo.spring.mapper;

import demo.spring.entity.MyUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MyUserMapper {
    @Insert("insert into user(user_id,username,password) values(#{user_id},#{name},#{passwd})")
    int add(MyUser user);

    @Select("select password from user where username=#{uname}")
    String findPwdbyUsername(String uname);

    @Select("select username,password from user where username=#{uname}")
    @Results(id="userMap",value={
            @Result(property = "userName",column = "username",javaType = String.class),
            @Result(property = "password",column = "password",javaType = String.class)
    })
    MyUser findUserbyUsername(String uname);

    //@Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    //int update(Student student);

    //@Delete("delete from  where ")
    //int deleteBysno(String sno);
}