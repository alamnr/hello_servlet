package com.async;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "async0" , urlPatterns = "/async0",asyncSupported = true)
public class Async0 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(Async0.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Boolean.TRUE.equals(req.getAttribute("dispatch"))) {
            log.info("Received dispatch, completing on the worker thread.");
            log.info("After complete called started: " + req.isAsyncStarted());
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            resp.getWriter().write("Async dispatch worked: " + sdf.format(date) + "\n");
        } else {
            resp.setContentType("text/plain");
            final AsyncContext actx = req.startAsync();
            actx.setTimeout(Long.MAX_VALUE);
            Runnable run = new Runnable() {

                @Override
                public void run() {
                    try {
                        req.setAttribute("dispatch", Boolean.TRUE);
                        Thread.currentThread().setName("Async0-Thread");
                        log.info("Putting AsyncThread to sleep");
                        Thread.sleep(2 * 1000);
                        log.info("Dispatching");
                        actx.dispatch();
                    } catch (InterruptedException x) {
                        log.error("Async1", x);
                    } catch (IllegalStateException x) {
                        log.error("Async1", x);
                    }

                }

            };
            Thread t = new Thread(run);
            t.start();
        }
    }

}
