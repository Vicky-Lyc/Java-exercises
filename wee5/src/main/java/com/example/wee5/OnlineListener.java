package com.example.wee5;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener {
    static private int onlinePeople;
    public OnlineListener() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlinePeople++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        onlinePeople--;
    }

    public static int getOnlinePeople() {
        return onlinePeople;
    }
}

