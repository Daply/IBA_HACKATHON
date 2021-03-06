package com.luckydrive.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/trip", "/private", "chat", "/user");
		// config.enableSimpleBroker("/");
		config.setApplicationDestinationPrefixes("/app");
		config.setUserDestinationPrefix("/user");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
	}

	/*
	 * @Override public void configureClientInboundChannel(ChannelRegistration
	 * registration) { registration.setInterceptors(new ChannelInterceptorAdapter()
	 * {
	 * 
	 * @Override public Message<?> preSend(Message<?> message, MessageChannel
	 * channel) {
	 * 
	 * StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message,
	 * StompHeaderAccessor.class);
	 * 
	 * if (StompCommand.CONNECT.equals(accessor.getCommand())) { String user =
	 * accessor.getFirstNativeHeader("user"); if (!StringUtils.isEmpty(user)) {
	 * List<GrantedAuthority> authorities = new ArrayList<>(); authorities.add(new
	 * SimpleGrantedAuthority("ROLE_USER")); Authentication auth = new
	 * UsernamePasswordAuthenticationToken(user, user, authorities);
	 * SecurityContextHolder.getContext().setAuthentication(auth);
	 * accessor.setUser(auth); } }
	 * 
	 * return message; } }); }
	 */

}
