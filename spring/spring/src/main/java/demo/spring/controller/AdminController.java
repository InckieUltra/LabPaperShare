package demo.spring.controller;

import demo.spring.entity.MyUser;
import demo.spring.entity.Permission;
import demo.spring.entity.Result;
import demo.spring.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private MyUserService myUserService;

    private MyUser myUser;

    @CrossOrigin
    @PostMapping("/api/admin/user/delete")
    public Result deleteuser(@RequestParam("user_id") Integer user_id) {
        try {
            this.myUserService.deleteUser(user_id);
        }catch (Exception e){
            return Result.fail("删除失败",null);
        }
        return Result.success("删除成功",null);
    }

    @CrossOrigin
    @PostMapping("/api/admin/alluser")
    public Result findalluser() {
        List<MyUser> res;
        try{
            res=this.myUserService.findallUser();
        }catch (Exception e){
            return Result.fail("查询失败",null);
        }
        return Result.success("查询成功",res);
    }

    @CrossOrigin
    @PostMapping("/api/admin/user/changerole")
    public Result deleteuser(@RequestParam("user_id") Integer user_id,
                             @RequestParam("role_id") Integer role_id) {
        try {
            this.myUserService.changeUserRole(user_id,role_id);
        }catch (Exception e){
            return Result.fail("修改失败",null);
        }
        return Result.success("修改成功",null);
    }
}
