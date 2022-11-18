package com.taghandler;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ClassicTagTest3 extends TagSupport {

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("In do end tag - after body");
        } catch (IOException e) {
            throw new JspException("IOException -"+e.toString());
        }
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("In do start tag - before body");
        } catch (IOException e) {
           throw new JspException("IOException - "+e.toString());
        }
        return EVAL_BODY_INCLUDE;
    }


    
}
