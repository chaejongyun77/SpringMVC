package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.dto.MemberDTO;
import org.fullstack4.chap01.service.LoginService;
import org.fullstack4.chap01.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/member/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CookieUtil cookieUtil = new CookieUtil();

        String cookieId= cookieUtil.readCookie(req);

        if(cookieId.equals("고객")){
            req.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(req,resp);
        }
        else{
            session.setAttribute("user_id",cookieId);
            //req.setAttribute("user_id",cookieId);
            req.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieUtil cookieUtil = new CookieUtil();
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String idSave = req.getParameter("idSave");

        String autoLogin = req.getParameter("autoLogin");

        HttpSession session = req.getSession();


        try {
            MemberDTO dto = LoginService.INSTANCE.login(id,pwd);
            if(dto.getUser_id() != null ){

                // 아이디 저장
                if(idSave !=null ){
                    if(idSave.equals("on")){
                        req.setAttribute("loginCheck",idSave);
                        Cookie cookie =cookieUtil.getCookie("save_id",dto.getUser_id(),"/",30);
                        //test


                        //
                        resp.addCookie(cookie);
                    }

                }
                if(idSave==null){
                    Cookie cookie =cookieUtil.getCookie("save_id","","/",0);
                        resp.addCookie(cookie);
                }
                // 자동 로그인
                if(autoLogin !=null){
                    if(autoLogin.equals("on")){

                        Cookie cookie =cookieUtil.getCookie("user_id",dto.getUser_id(),"/",30);
                        resp.addCookie(cookie);

                    }
                }

                session.setAttribute("user_id",dto.getUser_id());


                req.setAttribute("user_id",dto.getUser_id());
                req.getRequestDispatcher("/WEB-INF/views/login/loginPage.jsp").forward(req,resp);
            }
            else{
                resp.sendRedirect("/login/loginPage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
