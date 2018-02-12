package club.easyshare.controller.chooseblacka.websocket.jetty;

import club.easyshare.business.cache.AllTournamentsCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author huyuyang@lxfintech.com
 * @Title: JettyWebSocketController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-02-09 17:51:05
 */
@Controller
public class JettyWebSocketController {

    @Autowired
    private MyHandler myHandler;

    @RequestMapping("jettywebsocket")
    public String index(){
        return "chooseblacka/websocketjetty";
    }

    @RequestMapping("/send/{groupCode}/{userId}")
    @ResponseBody
    public String handle(@PathVariable String groupCode, @PathVariable String userId) throws Exception {
        String msg="用户"+userId+"向您发来一条消息";
        myHandler.sendMessages(groupCode,msg);
        return "true";
    }
}
