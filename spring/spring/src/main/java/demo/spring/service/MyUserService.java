package demo.spring.service;

import demo.spring.entity.MyUser;
import demo.spring.entity.Result;
import demo.spring.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MyUserService{

    public String findPwdbyUsername(String uname);

    public MyUser findUserbyUsername(String uname);

    public int addUser(MyUser user);

    public int findmaxUser_id();

    public int[] findPermission(int user_id);
}