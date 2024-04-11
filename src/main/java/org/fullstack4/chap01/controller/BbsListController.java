package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BbsModifyController", value = "/bbs/list")
public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<BbsDTO> dtoList = null;
        try {
            dtoList = BbsService.INSTANCE.bbsList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("list",dtoList);
        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
