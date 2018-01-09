package club.easyshare.controller.common.system;

import club.easyshare.service.common.system.UserService;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 21:37:23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/checkLogin")
    @ResponseBody
    public String header(HttpServletRequest request) {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        UserParameter userParameter=new UserParameter();
        userParameter.setUserName(userName).setPassword(password);
        User user=userService.login(userParameter);
        if (user!=null){
            return "true";
        }
        return "false";
    }

}
