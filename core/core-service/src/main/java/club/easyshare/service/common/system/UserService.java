package club.easyshare.service.common.system;
import club.easysharing.model.bean.system.User;
import club.easysharing.model.parameter.system.UserParameter;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 23:03:16
 */
public interface UserService {

    User login(UserParameter userParameter);

    User findByUserName(UserParameter userParameter);

    User register(UserParameter userParameter);
}
