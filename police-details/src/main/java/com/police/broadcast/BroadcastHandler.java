package com.police.broadcast;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


public class BroadcastHandler {

    private static final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private final Object MONITOR = new Object();
    
    public void add(WebSocketSession session) {
        synchronized (MONITOR) {
            if (!sessions.contains(session)) sessions.add(session);
        }
    }

    public void broadcast(String message) {
        for (WebSocketSession session : sessions) {
            try {
                if (session.isOpen()) session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
            }
        }
    }

    public void remove(WebSocketSession session) {
        synchronized (MONITOR) {
            sessions.remove(session);
        }
    }
}
