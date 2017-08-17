package com.mublog.config;

import java.io.IOException;
//import org.apache.log4j.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {
	
	//private static final Logger logger = Logger.getLogger(CORSFilter.class);
	 
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //logger.info("Filtering on...........................................................");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        chain.doFilter(req, res);
    }
 
    public void init(FilterConfig filterConfig) {}
 
    public void destroy() {}
}
