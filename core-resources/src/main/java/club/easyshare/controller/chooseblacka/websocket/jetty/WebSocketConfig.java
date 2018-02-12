package club.easyshare.controller.chooseblacka.websocket.jetty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author huyuyang@lxfintech.com
 * @Title: WebSocketConfig
 * @Copyright: Copyright (c) 2016
 * @Description: 注册WebSocket
 * 也可以用xml的方式
 * <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:websocket="http://www.springframework.org/schema/websocket"
        xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/websocket
        http://www.springframework.org/schema/websocket/spring-websocket.xsd">

        <websocket:handlers>
            <websocket:mapping path="/myHandler" handler="myHandler"/>
        </websocket:handlers>
        <bean id="myHandler" class="org.springframework.samples.MyHandler"/>
    </beans>
 * @Company: lxjr.com
 * @Created on 2018-02-11 11:56:30
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(), "/myHandler/{groupCode}/{userId}")
        .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
}
