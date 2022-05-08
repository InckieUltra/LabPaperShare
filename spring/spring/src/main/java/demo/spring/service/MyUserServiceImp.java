package demo.spring.service;

import demo.spring.entity.MyUser;
import demo.spring.entity.Permission;
import demo.spring.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.myUserMapper.add(user.getUser_id(),user.getUserName(),user.getPassword(),user.getEmail());
    }

    @Override
    public int findmaxUser_id(){
        return this.myUserMapper.findmaxUser_id();
    }

    @Override
    public List<Permission> findPermission(int user_id){
        return this.myUserMapper.findPermisssion(user_id);
    }

    public List<MyUser> findallUser() {
        return this.myUserMapper.findallUser();
    }

    public int deleteUser(int user_id){
        return this.myUserMapper.deleteUser(user_id);
    }

    public int changeUserRole(int user_id,int role_id){
        return this.myUserMapper.changeUserRole(user_id,role_id);
    }
}