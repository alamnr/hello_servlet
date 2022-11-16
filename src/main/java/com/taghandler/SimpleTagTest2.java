package com.taghandler;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest2 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
            getJspBody().invoke(null);
    }   

}