package club.easyshare.controller.chooseblacka.websocket.jetty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * @author huyuyang@lxfintech.com
 * @Title: WebSocketConfig
 * @Copyright: Copyright (c) 2016
 * @Description: 注册WebSocket
 * 也可以用xml的方式
 * <beans xmlns="http://www.springframework.org/schema/beans"
 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 * xmlns:websocket="http://www.springframework.org/schema/websocket"
 * xsi:schemaLocation="
 * http://www.springframework.org/schema/beans
 * http://www.springframework.org/schema/beans/spring-beans.xsd
 * http://www.springframework.org/schema/websocket
 * http://www.springframework.org/schema/websocket/spring-websocket.xsd">
 * <p>
 * <websocket:handlers>
 * <websocket:mapping path="/myHandler" handler="myHandler"/>
 * </websocket:handlers>
 * <bean id="myHandler" class="org.springframework.samples.MyHandler"/>
 * </beans>
 * @Company: lxjr.com
 * @Created on 2018-02-11 11:56:30
 */
@Configuration /*指明该类为Spring 配置类*/
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // 注册WebSocket Server实现类
        webSocketHandlerRegistry.addHandler(myHandler(), "/myHandler")
                //设置来自那些域名的请求可访问，默认为localhost
                .setAllowedOrigins("*")
                // WebSocket握手拦截器
                .addInterceptors(handshakeInterceptor())
                .addInterceptors(paramInterceptor())
                //.setHandshakeHandler(new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy()))
                //.withSockJS() //报404
        ;
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

    /**
     * 全局过滤器
     *
     * @return
     */
    @Bean
    public HandshakeInterceptor handshakeInterceptor() {
        return new club.easyshare.controller.chooseblacka.websocket.jetty.HandshakeInterceptor();
    }

    /**
     * 参数过滤器
     *
     * @return
     */
    @Bean
    public HandshakeInterceptor paramInterceptor() {
        return new ParamHandshakeInterceptor();
    }
}
