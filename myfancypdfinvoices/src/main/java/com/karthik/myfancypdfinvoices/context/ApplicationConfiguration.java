package com.karthik.myfancypdfinvoices.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.ApplicationLauncher;
import com.karthik.myfancypdfinvoices.model.User;
import com.karthik.myfancypdfinvoices.service.InvoiceService;
import com.karthik.myfancypdfinvoices.service.UserService;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@EnableWebMvc
public class ApplicationConfiguration {

  // @Bean
  // @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  // SCOPE IS USED TO KNOW HOW OBJECTS ARE CREATED LIKE SINGELTON / PROTOYPE OR
  // VARIOUS SCOPES IN SRPING DOCUMENTATION
  // public UserService userService() {
  // return new UserService();
  // }

  // !!!! This bean will automatically inject userservice bean above to below
  // service bean
  // We have used XML like below to configure beans
  /*
   * <?xml version="1.0" encoding="UTF-8"?>
   * <beans xmlns="http://www.springframework.org/schema/beans"
   * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   * xsi:schemaLocation="
   * http://www.springframework.org/schema/beans
   * http://www.springframework.org/schema/beans/spring-beans.xsd">
   * 
   * <!-- this is the legacy way of configuring spring -->
   * 
   * <bean id="userService"
   * class="com.karthik.myfancypdfinvoices.services.UserService"/>
   * 
   * <bean id="invoiceService"
   * class="com.karthik.myfancypdfinvoices.services.InvoiceService">
   * <constructor-arg value="userService"/>
   * </bean>
   * 
   * <bean id="objectMapper" class="com.fasterxml.jackson.databind.ObjectMapper"/>
   * </beans>
   */
  // @Bean
  // This is constructor injection

  // // When userservice is autowired and we are using settter injection
  // public InvoiceService invoiceService(UserService userService) {
  // InvoiceService invoiceService = new InvoiceService();
  // invoiceService.setUserService(userService);
  // return invoiceService;
  // }
  // public InvoiceService invoiceService(UserService userService) {
  // return new InvoiceService(userService);
  // }

  // If we are usign @requestparams we can do like below to check if valid or not
  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
