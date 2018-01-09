package club.easyshare.glue.system;

import club.easyshare.business.system.UserBusiness;
import club.easyshare.dao.jpa.system.UserDAO;
import club.easyshare.framework.utils.MD5Util;
import club.easyshare.glue.base.BaseGlue;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:04:08
 */
@Component
public class UserGlue extends BaseGlue{

    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    private UserDAO userDAO;

    public User login(User userParameter){
        String userName=userParameter.getUserName();
        String password= userParameter.getPassword();
        User user=convertIgnoreNullProperty(userDAO.findByUserNameAndPassword(userName,password),User.class);
        return user;
    }

    public User findByUserName(UserParameter userParameter) {
        User user=convertIgnoreNullProperty(userDAO.findByUserName(userParameter.getUserName()),User.class);
        return user;
    }
}
