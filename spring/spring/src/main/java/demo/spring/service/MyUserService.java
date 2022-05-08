package demo.spring.service;

import demo.spring.entity.MyUser;
import demo.spring.entity.Permission;

import java.util.List;

public interface MyUserService{

    public String findPwdbyUsername(String uname);

    public MyUser findUserbyUsername(String uname);

    public int addUser(MyUser user);

    public int findmaxUser_id();

    public List<Permission> findPermission(int user_id);

    public List<MyUser> findallUser();

    public int deleteUser(int user_id);

    public int changeUserRole(int user_id,int role_id);
}