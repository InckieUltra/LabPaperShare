package demo.spring.service;

import demo.spring.entity.MyUser;
import demo.spring.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MyUserService{

    public int add(MyUser myUser);

    public String findPwdbyUsername(String uname);

    public String gh();
}