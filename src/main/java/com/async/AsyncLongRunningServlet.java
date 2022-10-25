package com.async;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import com.async.listener.AppAsyncListener;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AsyncLongRunningServlet", asyncSupported = true)
public class AsyncLongRunningServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(Async0.class);
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.info("Request Processing Thread " + Thread.currentThread().getName());
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><head><title>Asynchronous servlet</title></head><body>");
        printWriter.println("Request Processing Thread " + Thread.currentThread().getName());
        printWriter.println("<br>");
        printWriter.println("<progress id='progress' max='100'></progress>");
        printWriter.println("<br>");

        AsyncContext actx = request.startAsync();
        actx.addListener(new AppAsyncListener());
        actx.setTimeout(12000);
        // release of request processing thread
        actx.start(() -> {
            printWriter.println("<br>");
            printWriter.println("Async thread Name " + Thread.currentThread().getName());
            printWriter.println("<br>");
            int i = 0;
            while (i < 100) {
                printWriter.println("<script>document.getElementById('progress').value=\"" + i + "\";</script>");
                printWriter.flush();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                i++;
            }
            printWriter.println("</body></html>");
            actx.complete();
        });
        printWriter.println("<br>");
        printWriter.println("End of response");

    }

}
