package com.example.javaejb;

import EjbPrac.WelcomeMsg;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;

@Path("/hello-world")
public class HelloResource {
    private static Connection connection_d=null;
    @EJB(beanName = "WelcomeMsgBean")
    WelcomeMsg welcomeMsg;

    @GET
    @Produces("text/plain")
    public String hello() {

        return welcomeMsg.returnWelcomeMsg();
    }
}