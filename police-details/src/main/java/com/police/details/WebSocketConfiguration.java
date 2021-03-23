package com.police.details;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

import com.police.broadcast.BroadcastHandler;

@EnableWebSocket
@EnableScheduling
@Configuration
public class WebSocketConfiguration extends SpringBootServletInitializer implements WebSocketConfigurer {

	// method to send alerts to police portal once customer do any violation
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(policeWebSocketHandler(), "/violationAlerts").setAllowedOrigins("*").withSockJS();
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
	}
	
	@Bean
	public WebSocketHandler policeWebSocketHandler() {
		return new PerConnectionWebSocketHandler(WebSocketHandler.class);
	}

	@Bean
	public BroadcastHandler createBroadcastHandler() {
		return new BroadcastHandler();
	}

}
