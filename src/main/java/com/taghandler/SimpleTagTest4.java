package com.taghandler;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest4 extends SimpleTagSupport {

    String movies[] = {"Tarjan","Gandu", "Kamasutra"};
    @Override
    public void doTag() throws JspException, IOException {
        for (String string : movies) {
            getJspContext().setAttribute("movie", string);
            getJspBody().invoke(null);
        }
    }
    
}
