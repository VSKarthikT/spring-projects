package com.karthik;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import com.karthik.simplebank.web.SimpleBankServlet;

public class Appfire {
  public static void main(String[] args) throws LifecycleException {
    SimpleBankServlet simpleBankServlet = new SimpleBankServlet();
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    tomcat.getConnector();
    Context ctx = tomcat.addContext("", null);
    Wrapper servlet = Tomcat.addServlet(ctx, "SimpleBankServlet", simpleBankServlet);
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/*");
    tomcat.start();
  }

}