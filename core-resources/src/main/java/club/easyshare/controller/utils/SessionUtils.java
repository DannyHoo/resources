package club.easyshare.controller.utils;


import club.easysharing.model.bean.system.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dannyhoo
 * @Title: SessionUtils
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-11 15:57:32
 */
public class SessionUtils {

    private static final String USER_INFO_SESSION_ID = "USER_INFO_SESSION_ID";


    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        return httpSession;
    }

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

    /**
     * 向Session中存储当前登录用户
     *
     * @param request
     * @param user
     */
    public static void setCurrentUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(USER_INFO_SESSION_ID, JSON.toJSONString(user));
    }

    /**
     * 从Session中清除当前登录用户
     *
     * @param request
     */
    public static void deleteCurrentUser(HttpServletRequest request) {
        request.getSession().setAttribute(USER_INFO_SESSION_ID, null);
    }

}
