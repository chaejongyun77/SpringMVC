package org.fullstack4.chap01.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener
public class F4Applistener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        log.info("=============init========");
        log.info("=============init========");
        log.info("=============ㄴㅇinit========");
        log.info("=============ㄴㅇinit========");
        log.info("=============ㄴㅇinit========");
        log.info("=============ㄴㅇinit========");

        System.out.println("찍혀야됨");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appName","W2");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        log.info("=============destory=========");
        log.info("=============destory=========");
        log.info("=============destory=========");
    }

}
