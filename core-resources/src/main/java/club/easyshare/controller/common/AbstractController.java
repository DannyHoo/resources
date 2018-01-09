package club.easyshare.controller.common;

import club.easysharing.model.bean.system.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AbstractController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-09 22:40:13
 */
public class AbstractController {

    private static final String USER_INFO_SESSION_ID = "USER_INFO_SESSION_ID";

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request) {
        Object currentUserInfo = request.getSession().getAttribute(USER_INFO_SESSION_ID);
        if (currentUserInfo == null) {
            return null;
        }
        User currentUser = JSON.parseObject(currentUserInfo.toString(), User.class);
        return currentUser;
    }

}
