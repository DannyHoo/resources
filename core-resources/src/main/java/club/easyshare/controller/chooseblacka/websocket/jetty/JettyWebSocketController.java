package club.easyshare.controller.chooseblacka.websocket.jetty;

import club.easyshare.business.cache.AllTournamentsCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
@RequestMapping("/jettywebsocket")
public class JettyWebSocketController {

    @Autowired
    private MyHandler myHandler;

    @RequestMapping("/chat/{groupCode}/{userId}")
    public ModelAndView index(@PathVariable String groupCode, @PathVariable String userId){
        ModelAndView modelAndView=new ModelAndView("chooseblacka/websocketjetty");
        modelAndView.addObject("userId",userId);
        modelAndView.addObject("groupCode",groupCode);
        return modelAndView;
    }

    @RequestMapping("/sendMsg/{groupCode}/{userId}")
    @ResponseBody
    public String handle(@PathVariable String groupCode, @PathVariable String userId) throws Exception {
        String msg="用户"+userId+"发来一条消息";
        myHandler.sendMessages(groupCode,msg);
        return "true";
    }
}
