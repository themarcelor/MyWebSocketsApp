/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themarcelor.ws;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.EndpointConfig;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/echo")
public class MyWebSocketsServlet extends HttpServlet {
 
    @OnOpen
    public void onOpen(Session session, EndpointConfig ePointConf) {
        System.out.println("Web Socket connection is now opened.");
    }   
    
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            System.out.println("The client sent a message through session: " + session.getId());  
            session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
 
    @OnClose
    public void onClose(Session session) {
        System.out.println("Web Socket connection is now closed.");
    }
}
