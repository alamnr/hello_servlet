package com.taghandler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.bean.Movie;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagTest5 extends SimpleTagSupport{

    private List movieList;

    @Override
    public void doTag() throws JspException, IOException {
       Iterator i = movieList.iterator();
       while(i.hasNext()){
        Movie movie = (Movie) i.next();
        getJspContext().setAttribute("movie", movie);
        getJspBody().invoke(null);
       }
    }

    public void setMovieList(List movieList) {
        this.movieList = movieList;
    }

    
    
}
