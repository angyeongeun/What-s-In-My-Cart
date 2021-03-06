package com.cartrapido.main.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        System.out.println("로그인 석세스핸들러");
        session.setAttribute("username", authentication.getName());
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roles.contains("ROLE_USER")){
            response.sendRedirect("/clientMain");
        }else if(roles.contains("ROLE_SHOPPER")){
            response.sendRedirect("/shopperMain");
        }else if(roles.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin/dashboard");
        }
    }
}

