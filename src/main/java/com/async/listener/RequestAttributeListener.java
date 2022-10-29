package com.async.listener;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServlet;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    private static Log log = LogFactory.getLog(RequestAttributeListener.class);
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("A : "+srae.getName() + " -> " + srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("M : "+srae.getName() + " -> " + srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("P : "+srae.getName() + " -> " + srae.getValue());
    }

}



