package com.taghandler;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ClassicTagTest1 extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
       JspWriter out = pageContext.getOut();

       try {
            out.println("Classic tag output");  
       } catch (IOException e) {
            throw new JspException("IOException - " + e.toString());
       }
       return SKIP_BODY;
    }
    
}
