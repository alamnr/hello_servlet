package com.taghandler;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ClassicIteratorTagTest4 extends TagSupport {

    String[] movies = {"Tarzan", "Zane", "Leon"};
    int movieCounter;
    @Override
    public int doAfterBody() throws JspException {
       if(movieCounter < movies.length) {
            pageContext.setAttribute("movie", movies[movieCounter]);
            movieCounter ++;
            return EVAL_BODY_AGAIN;
       } else {
        return SKIP_BODY;
       }
    }

    @Override
    public int doEndTag() throws JspException {
       return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        movieCounter = 0;
        pageContext.setAttribute("movie", movies[movieCounter]);
        movieCounter ++;
        return EVAL_BODY_INCLUDE;
    }
    
}
