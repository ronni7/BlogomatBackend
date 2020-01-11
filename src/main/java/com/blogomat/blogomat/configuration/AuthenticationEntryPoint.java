package com.blogomat.blogomat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        //super.commence(request, response, authException);
        response.addHeader("Authenticate", "basic" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Unauthorized" + authException.getMessage());

    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Error");
        super.afterPropertiesSet();
    }
}
