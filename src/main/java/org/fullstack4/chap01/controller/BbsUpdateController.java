package org.fullstack4.chap01.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;
import org.fullstack4.chap01.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@Log4j2
@WebServlet(name = "BbsUpdateController", value = "/bbs/update")
public class BbsUpdateController extends HttpServlet {
    private BbsService service = BbsService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idx = (req.getParameter("idx") != null ? Integer.parseInt(req.getParameter("idx")) : 0);
        if(idx <=0){

        }
        else{
            try{

                BbsDTO bbsDTO =  service.view(idx);


            }catch(Exception e){
                log.info("수정에러 : " +e.getMessage());
                e.printStackTrace();
            }

            req.getRequestDispatcher("/WEB-INF/bbs/update.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CommonUtils commonUtils = new CommonUtils();

        boolean check_flag = true;
        int[] check =new int[3];

        String title = req.getParameter("title");
        check[0]  = commonUtils.requiredInput(title);



        String reg_date = req.getParameter("reg_date");
        check[1]= commonUtils.requiredInput(reg_date);

        String content = req.getParameter("content");
        check[2] =commonUtils.requiredInput(content);


        String[] hobby = req.getParameterValues("hobby");
        //    check[3] = commonUtils.requiredInputArr(hobby);

        String sex = req.getParameter("sex");
        //  check[4] = commonUtils.requiredInput(sex);

        resp.setContentType("text/html; charset=UTF-8");

        for(int i =0; i<check.length; i++){
            if(check[i]==1){
                check_flag=false;
            }
        }


        if(check_flag ){
            System.out.println("수정 완료");
            resp.sendRedirect("/bbs/list");

        }else {

            System.out.println("수정 실패");
            req.setAttribute("list",check);
            req.getRequestDispatcher("/WEB-INF/bbs/update.jsp").forward(req,resp);

        } }
    }

