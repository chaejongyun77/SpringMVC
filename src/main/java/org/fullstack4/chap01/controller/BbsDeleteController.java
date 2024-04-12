package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.service.BbsService;
import org.fullstack4.chap01.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.rmi.server.ExportException;

@WebServlet(name = "BbsDeleteController", value = "/bbs/delete")
public class BbsDeleteController extends HttpServlet {
    private BbsService service = BbsService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommonUtils commonUtils = new CommonUtils();
        int check_flag = 0;

       // check_flag = commonUtils.requiredInput(idx);

        try {
            resp.sendRedirect("/bbs/list");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 완료 : POST");

        String idx = req.getParameter("idx");
        if(idx !=null && Integer.parseInt(idx)>0){
            try {
                int result = service.delete(Integer.parseInt(idx));
                if(result>0){
                    resp.sendRedirect("/bbs/list");
                }
                else{
                    req.getRequestDispatcher("/WEB-INF/views/bbs/view.jsp?idx"+idx).forward(req,resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            req.getRequestDispatcher("/WEB-INF/views/bbs/view.jsp?idx"+idx).forward(req,resp);
        }



    }
}
