package com.demo.fraudalertdashboard.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring boot application class for Dashboard.
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.demo.fraudalertdashboard.dashboard", "com.demo.fraudalertdashboard.dao"})
public class FraudAlertDashboard extends WebMvcConfigurerAdapter{

	  public static void main(String[] args)
	  {
		  SpringApplication.run(FraudAlertDashboard.class, args);
	  }
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}
}

