package demo.spring.controller;

import demo.spring.entity.MyUser;
import demo.spring.entity.Permission;
import demo.spring.entity.Result;
import demo.spring.entity.Role;
import demo.spring.mapper.MyUserMapper;
import demo.spring.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private MyUserService myUserService;

    private MyUser myUser;

    @Autowired
    private MyUserMapper myUserMapper;

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
    @PostMapping("/api/admin/allrole")
    public Result findallrole() {
        List<Role> res;
        try{
            res=this.myUserService.findallRole();
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

    @CrossOrigin
    @PostMapping("/api/admin/allpermission")
    public Result findallpermission() {
        List<Permission> res;
        try{
            res=this.myUserService.findallPermission();
        }catch (Exception e){
            return Result.fail("查询失败",null);
        }
        return Result.success("查询成功",res);
    }

    @CrossOrigin
    @PostMapping("/api/admin/addrole")
    public Result addrole(@RequestParam("name") String name,
                          @RequestParam("comment") String comment) {
        Role r=new Role();
        r.setRole_id(myUserMapper.findmaxRole_id()+1);
        r.setName(name);
        r.setComment(comment);
        try{
            this.myUserService.addRole(r);
        }catch (Exception e){
            return Result.fail("失败",null);
        }
        return Result.success("成功",r);
    }

    @CrossOrigin
    @PostMapping("/api/admin/mofidypermission")
    public Result addrole(@RequestBody ModifyPermissionRequest modifyPermissionRequest) {
        int[] l=modifyPermissionRequest.getPermission_id();
        for(int i = 0; i< l.length; i++) {
            try {
                this.myUserService.RoleaddPermission(modifyPermissionRequest.getRole_id(),l[i]);
            } catch (Exception e) {
                return Result.fail("失败", null);
            }
        }
        return Result.success("成功",null);
    }
}
