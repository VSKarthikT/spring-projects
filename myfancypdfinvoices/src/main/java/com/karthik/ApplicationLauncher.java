package com.karthik;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.karthik.myfancypdfinvoices.context.ApplicationConfiguration;

import jakarta.servlet.ServletContext;

public class ApplicationLauncher {

  public static void main(String[] args) throws LifecycleException {

    // Tomcat server instaance
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    // Makes this accept HTTP requests
    tomcat.getConnector();
    // context path :8080/ requests will be handeled
    //
    // WITH spring MVC
    //
    Context tomcatCtx = tomcat.addContext("", null);
    WebApplicationContext appCtx = createApplicationContext(tomcatCtx.getServletContext());
    DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);
    Wrapper servlet = Tomcat.addServlet(tomcatCtx, "dispatcherServlet", dispatcherServlet);
    // Without spring MVC
    // Docbase is base directory
    // Context ctx = tomcat.addContext("", null);
    // Wrapper servlet = Tomcat.addServlet(ctx, "MyFancyPdfInvoicesServlet", new
    // MyFancyPdfInvoicesServlet());
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/*");
    tomcat.start();
  }

  //
  // WITH spring MVC
  //
  public static WebApplicationContext createApplicationContext(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(ApplicationConfiguration.class);
    ctx.setServletContext(servletContext);
    ctx.refresh();
    ctx.registerShutdownHook();
    return ctx;

  }
}
