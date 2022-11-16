package com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class AdvisorTagHandler extends SimpleTagSupport {

    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("Hello " + user + "<br/>");
        getJspContext().getOut().write("Your advice is - " + getAdvice());
    }

    String getAdvice(){
        String[] adviceStrings = {"That color's not working for you.", 
            "You should call in sick.", "You might want to rethink that haircut."};
            int random = (int) (Math.random() * adviceStrings.length);
            return adviceStrings[random];
    }
    
}
