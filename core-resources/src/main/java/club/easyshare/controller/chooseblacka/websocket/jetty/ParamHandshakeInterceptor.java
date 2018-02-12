package club.easyshare.controller.chooseblacka.websocket.jetty;

import org.assertj.core.util.Strings;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ParamHandshakeInterceptor
 * @Copyright: Copyright (c) 2016
 * @Description: WebSocket握手拦截器用来拦截和处理客户端和服务器端分别在握手前和握手后的事件，我们这里添加这个拦截器是为了清晰的知道什么时候以及是否握手成功。
 * @Company: lxjr.com
 * @Created on 2018-02-12 11:08:15
 */
public class ParamHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        String groupCode = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter("groupCode");
        String userId = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter("userId");
        attributes.put("groupCode", groupCode);
        attributes.put("userId", userId);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
