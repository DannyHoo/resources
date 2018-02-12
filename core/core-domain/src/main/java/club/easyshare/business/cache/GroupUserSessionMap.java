package club.easyshare.business.cache;

import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GroupUserSessionMap
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-11 18:12:37
 */
public class GroupUserSessionMap implements Serializable {
    /* 所有用户-socket关系信息(用户id：socket) */
    private Map<String, WebSocketSession> sessionMap = new HashMap<>();

    public Map<String, WebSocketSession> getSessionMap() {
        return sessionMap;
    }

    public GroupUserSessionMap setSessionMap(Map<String, WebSocketSession> sessionMap) {
        this.sessionMap = sessionMap;
        return this;
    }
}
