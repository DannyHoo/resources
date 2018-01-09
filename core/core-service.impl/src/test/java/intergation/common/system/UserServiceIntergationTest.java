package intergation.common.system;

import club.easyshare.service.common.system.UserService;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;
import com.alibaba.druid.filter.AutoLoad;
import com.alibaba.fastjson.JSON;
import intergation.BaseServiceSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceIntergationTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-08 23:22:59
 */
public class UserServiceIntergationTest extends BaseServiceSpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUserTest(){
        UserParameter userParameter=new UserParameter();
        userParameter.setUserName("admin");
        User user=userService.findByUserName(userParameter);
        System.out.println(JSON.toJSONString(user));
    }
}
