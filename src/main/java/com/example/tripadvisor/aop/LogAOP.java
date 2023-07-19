package com.example.tripadvisor.aop;

import com.example.tripadvisor.pojo.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.PortableServer.POA;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;

import java.util.Date;


@Aspect
@Component
public class LogAOP {
    @Autowired
    private HttpServletRequest request;
    //log4j
    private final static Logger logger= LoggerFactory.getLogger(LogAOP.class);

    @Pointcut("execution(* com.example.tripadvisor.controller.backstage.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        //RECORD: visitTime
        Date visitTime = new Date();
        request.setAttribute("visitTime",visitTime);
    }

    //good way record
    @After("pointCut()")
    public void doAfter(){
        Log log = new Log();

        //RECORD: visitTime timespan
        Date visitTime = (Date)request.getAttribute("visitTime");
        Date current = new Date();
        int executionTime = (int)(current.getTime() - visitTime.getTime());

        //RECORD: request ip
        String ip = request.getRemoteAddr();

        //RECORD: request url
        String url = request.getRequestURI();

        //RECORD: request user in security
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof User){
            String username = ((User) user).getUsername();
            log.setUsername(username);
        }

        log.setVisitTime(visitTime);
        log.setExecutionTime(executionTime);
        log.setIp(ip);
        log.setUrl(url);

        logger.info(log.toString());
    }

    //bad way record
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void afterThrowing(Throwable ex){
        Log log = new Log();

        //RECORD: visitTime timespan
        Date visitTime = (Date)request.getAttribute("visitTime");
        Date current = new Date();
        int executionTime = (int)(current.getTime() - visitTime.getTime());

        //RECORD: request ip
        String ip = request.getRemoteAddr();

        //RECORD: request url
        String url = request.getRequestURI();

        //RECORD: request user in security
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof User){
            String username = ((User) user).getUsername();
            log.setUsername(username);
        }

        //EXCEPTION RECORD: exception
        String exMessage = ex.getMessage();

        log.setVisitTime(visitTime);
        log.setExecutionTime(executionTime);
        log.setIp(ip);
        log.setUrl(url);
        log.setExceptionMessage(exMessage);

        logger.info(log.toString());
    }
}
