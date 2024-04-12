package org.fullstack4.chap01.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

@Log4j2
@WebFilter(urlPatterns = {"/bbs/*"}) //로그인 하지 않았을때 bbs로
public class LoginCheckFilter implements Filter { //javax필터
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            log.info("Login Check Filter");
            HttpServletRequest req  = (HttpServletRequest) request;
            HttpServletResponse res  = (HttpServletResponse) response;
            HttpSession session = req.getSession();

            //세션값이 비어있으면
            if(session.getAttribute("user_id") == null){
                res.sendRedirect("/member/login");

                    return;
            }
        chain.doFilter(req,res);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
