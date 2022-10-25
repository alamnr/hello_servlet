package com.async.listener;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppAsyncListener implements AsyncListener {

    private static final Log log = LogFactory.getLog(AppAsyncListener.class);

    @Override
    public void onComplete(AsyncEvent arg0) throws IOException {
       log.info("AppAsyncListener onComplete");
    }

    @Override
    public void onError(AsyncEvent arg0) throws IOException {
        log.info("AppAsyncListener onError");
        
    }

    @Override
    public void onStartAsync(AsyncEvent arg0) throws IOException {
        log.info("AppAsyncListener onStartAsync");
        
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        log.info("AppAsyncListener onTimeout");
        ServletResponse resp = asyncEvent.getAsyncContext().getResponse();
        PrintWriter out = resp.getWriter();
        out.write("Time out error in processing");
        
    }
    
}
