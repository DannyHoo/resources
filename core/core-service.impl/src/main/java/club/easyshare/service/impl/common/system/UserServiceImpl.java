package club.easyshare.service.impl.common.system;

import club.easyshare.glue.system.UserGlue;
import club.easyshare.service.common.system.UserService;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 23:02:51
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserGlue userGlue;

    /**
     * 用户登录
     * @param userParameter
     * @return
     */
    @Override
    public User login(UserParameter userParameter) {
        try {
            return userGlue.login(userParameter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findByUserName(UserParameter userParameter) {
        return userGlue.findByUserName(userParameter);
    }
}
