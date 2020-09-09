package com.example.gameManagerapi.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CorsFilter implements Filter {
	
	private String originPermitida= "http://localhost:4200";

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", originPermitida);
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "False");
		
		
		if("OPTIONS".equals(request.getMethod()) && originPermitida.equals(request.getHeader("Origin")) ) {
			((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS, DELETE");
			((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			((HttpServletResponse) response).setHeader("Access-Control-Allow-Max-Age", "3600");
			
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, resp);
		}
		
	}

}
