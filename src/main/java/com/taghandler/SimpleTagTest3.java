package com.taghandler;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest3 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
       getJspContext().setAttribute("message", "Wear condom before play");
       getJspBody().invoke(null);
    }
    
}
