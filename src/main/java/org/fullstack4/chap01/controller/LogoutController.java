package org.fullstack4.chap01.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name ="LogoutController" ,value="/member/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("일로 들ㅇ옴?");

        HttpSession session = req.getSession();

        session.removeAttribute("user_id");

        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){

            if(c.getName().equals("user_id") ){
                c.setPath("/");
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }



        resp.sendRedirect("/bbs/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
