package demo.spring.service;

import demo.spring.entity.MyUser;
import demo.spring.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class MyUserServiceImp implements  MyUserService{
    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public int add(MyUser myUser) {
        return this.myUserMapper.add(myUser);
    }

    @Override
    public String findPwdbyUsername(String uname) {
        return this.myUserMapper.findPwdbyUsername(uname);
    }

    @Override
    public MyUser findUserbyUsername(String uname){
        return this.myUserMapper.findUserbyUsername(uname);
    }
}