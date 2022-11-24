package com.filter;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

public class GZIPServletOutputStream extends ServletOutputStream {

   
    GZIPOutputStream  internalGzipOS;

    public GZIPServletOutputStream(ServletOutputStream sos) throws IOException {
        this.internalGzipOS = new GZIPOutputStream(sos);
    }

      

    @Override
    public void write(int param) throws IOException {
        internalGzipOS.write(param);        
    }



    @Override
    public boolean isReady() {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public void setWriteListener(WriteListener arg0) {
        // TODO Auto-generated method stub
        
    }



     
}