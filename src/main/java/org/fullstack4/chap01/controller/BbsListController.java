package org.fullstack4.chap01.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
@Log4j2
@WebServlet(name = "BbsModifyController", value = "/bbs/list")
public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<BbsDTO> dtoList = null;

        ServletContext servletContext = req.getServletContext();

        log.info("appName : "+ servletContext.getAttribute("appName"));
        try {
            dtoList = BbsService.INSTANCE.bbsList();
            req.setAttribute("list",dtoList);
            req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
