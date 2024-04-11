package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BbsDeleteController", value = "/bbs/delete")
public class BbsDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommonUtils commonUtils = new CommonUtils();
        int check_flag = 0;
        String idx = req.getParameter("idx");
        check_flag = commonUtils.requiredInput(idx);

        resp.sendRedirect("/bbs/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 완료 : POST");


        resp.sendRedirect("/bbs/list");
    }
}
