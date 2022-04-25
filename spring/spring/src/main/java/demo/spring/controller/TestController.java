package demo.spring.controller;

import demo.spring.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    MyUserService myUserService;
    @RequestMapping( value = "/queryuser", method = RequestMethod.GET)
    public String getpwd(){
        return this.myUserService.findPwdbyUsername("root");
    }
}
