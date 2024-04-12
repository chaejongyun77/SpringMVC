package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;
import org.fullstack4.chap01.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;




@WebServlet(name = "BbsRegistController", value = "/bbs/regist")
public class BbsRegistController extends HttpServlet {

    private BbsService service = BbsService.INSTANCE;

  //  static  boolean check_flag = true;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CommonUtils commonUtils = new CommonUtils();

        boolean check_flag = true;
        int[] check =new int[4];

        String title = req.getParameter("title");
        check[0]  = commonUtils.requiredInput(title);
        String user_id = req.getParameter("user_id");

        String display_date = req.getParameter("display_date");


      //  String reg_date = req.getParameter("reg_date");
         check[1]= commonUtils.requiredInput(display_date);

        String content = req.getParameter("content");
         check[2] =commonUtils.requiredInput(content);


         String[] hobby = req.getParameterValues("hobby");
      check[3] = commonUtils.requiredInputArr(hobby);

        String sex = req.getParameter("sex");
      //  check[4] = commonUtils.requiredInput(sex);

        resp.setContentType("text/html; charset=UTF-8");

        for(int i =0; i<check.length; i++){
            if(check[i]==1){
                check_flag=false;
            }
        }

        if(check_flag ){
            System.out.println("등록 완료");
            int read_cnt=0;

            BbsDTO bbsDTO =BbsDTO.builder()
                    .user_id("user_id")
                    .title(title)
                    .content(content)
                    .display_date(display_date)
                    .read_cnt(read_cnt)
                    .build();

            int result=0;
            try{
                result = service.regist(bbsDTO);
                System.out.println("result: " + result);
            }catch(Exception e){
                e.printStackTrace();;
            }

            if(result >0){
                resp.sendRedirect("/bbs/list");
            }
            else{
                req.setAttribute("result",result);
                req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req,resp);
            }

        }
        else{
            req.setAttribute("list",check);
            req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req,resp);
        }






    }
}
