package club.easyshare.glue.system;

import club.easyshare.business.system.UserBusiness;
import club.easyshare.dao.data.system.DictDataDO;
import club.easyshare.dao.data.system.UserDO;
import club.easyshare.dao.jpa.system.DictDataDAO;
import club.easyshare.dao.jpa.system.UserDAO;
import club.easyshare.framework.utils.Generator;
import club.easyshare.framework.utils.MD5Util;
import club.easyshare.glue.base.BaseGlue;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author huyuyang@lxfintech.com
 * @Title: UserGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:04:08
 */
@Component
public class UserGlue extends BaseGlue {


    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    private UserDAO userDAO;

    /**
     * 用户登录
     *
     * @param userParameter
     * @return
     * @throws Exception
     */
    public User login(UserParameter userParameter) throws Exception {
        User loginResult = null;

        User userFound = findByUserName(userParameter);
        if (userFound != null) {
            String password = userBusiness.decryptPassword(userParameter.getPassword(), getRsaPrivateKey());
            String md5Password = MD5Util.md5HexTwoSourceAndSalt(password, userFound.getSalt());
            if (userFound.getPassword().equals(md5Password)) {
                loginResult = userFound;
            }
        }
        return loginResult;
    }

    public User findByUserName(UserParameter userParameter) {
        User user = convertIgnoreNullProperty(userDAO.findByUserName(userParameter.getUserName()), User.class);
        return user;
    }

    /**
     * 用户注册
     *
     * @param userParameter
     * @return
     * @throws Exception
     */
    public User register(UserParameter userParameter) throws Exception {
        User user = new User();
        String password = userBusiness.decryptPassword(userParameter.getPassword(), getRsaPrivateKey());
        String salt = Generator.getStringRandom(8);
        user.setEmail(userParameter.getEmail())
                .setUserName(userParameter.getUserName())
                .setSalt(salt)
                .setPassword(MD5Util.md5HexTwoSourceAndSalt(password, salt));
        UserDO userDO = convertIgnoreNullProperty(user, UserDO.class);
        userDO = userDAO.save(userDO);
        user = convertIgnoreNullProperty(userDO, User.class);
        return user;
    }
}
