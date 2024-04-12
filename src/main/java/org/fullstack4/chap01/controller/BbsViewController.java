package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BbsViewController", value = "/bbs/view")
public class BbsViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {


            int idx = Integer. parseInt(req.getParameter("idx"));

            BbsDTO dto = BbsService.INSTANCE.view(idx);
            req.setAttribute("dto",dto);
            req.getRequestDispatcher("/WEB-INF/views/bbs/view.jsp").forward(req,resp);

        } catch (Exception e) {
           e.printStackTrace();

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
