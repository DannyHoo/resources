package club.easyshare.controller.chooseblacka.websocket.jetty;

import club.easyshare.business.cache.AllTournamentsCache;

import club.easyshare.business.cache.GroupUserSessionMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: MyHandler
 * @Copyright: Copyright (c) 2016
 * @Description: WebSocket处理器
 * 建立连接后触发的回调 afterConnectionEstablished(WebSocketSession session)
 * 收到消息时触发的回调 handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception;
 * 传输消息出错时触发的回调 handleTransportError(WebSocketSession session, Throwable exception) throws Exception;
 * 断开连接后触发的回调 afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception;
 * 是否处理分片消息 supportsPartialMessages();
 * @Company: lxjr.com
 * @Created on 2018-02-11 11:54:58
 */
@Controller
@RequestMapping("/websocket/group")
public class MyHandler extends TextWebSocketHandler {

    /**
     * 连接成功
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String groupCode = getValueFromWebSocketSession(session, "groupCode");
        String userId = getValueFromWebSocketSession(session, "userId");
        if (AllTournamentsCache.groupSocketSessionMap.get(groupCode) == null) {
            GroupUserSessionMap groupUserSessionMap = new GroupUserSessionMap();
            AllTournamentsCache.groupSocketSessionMap.put(groupCode, groupUserSessionMap);
        }
        if (AllTournamentsCache.groupSocketSessionMap.get(groupCode).getSessionMap().get(userId) == null) {
            AllTournamentsCache.groupSocketSessionMap.get(groupCode).getSessionMap().put(userId, session);
        }
        // 上线通知
        sendMessages(groupCode,"用户" + userId + "上线……连接成功……");
    }

    /**
     * 发送消息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (!session.isOpen()) {
            return;
        }
        super.handleTextMessage(session, message);
        // 发送消息
        session.sendMessage(message);
        System.out.println(String.valueOf(message.toString()));
    }

    /**
     * （向多个session）批量发送消息
     *
     * @param groupCode
     * @param message
     * @throws Exception
     */
    public void sendMessages(String groupCode, String message) throws Exception {
        TextMessage textMessage = new TextMessage(message);
        List<WebSocketSession> webSocketSessionList = AllTournamentsCache.getWebSocketSessionListOfGroup(groupCode);
        // 循环给本组内所有用户发送信息
        for (WebSocketSession webSocketSession : webSocketSessionList) {
            handleTextMessage(webSocketSession, textMessage);
        }
    }

    /**
     * 连接关闭
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Connection Closed！");
    }

    /**
     * 从session中获取参数值
     *
     * @param session
     * @param paramName
     * @return
     */
    private String getValueFromWebSocketSession(WebSocketSession session, String paramName) {
        String result = "";
        if (session != null) {
            return session.getAttributes().get(paramName) == null ? "" : session.getAttributes().get(paramName).toString();
        }
        return result;
    }


}
