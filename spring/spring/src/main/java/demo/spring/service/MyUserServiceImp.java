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
    public String findPwdbyUsername(String uname) {
        return this.myUserMapper.findPwdbyUsername(uname);
    }

    @Override
    public MyUser findUserbyUsername(String uname){
        return this.myUserMapper.findUserbyUsername(uname);
    }

    @Override
    public int addUser(MyUser user){
        return this.myUserMapper.add(user.getUser_id(),user.getUserName(),user.getPassword());
    }

    @Override
    public int findmaxUser_id(){
        return this.myUserMapper.findmaxUser_id();
    }
}