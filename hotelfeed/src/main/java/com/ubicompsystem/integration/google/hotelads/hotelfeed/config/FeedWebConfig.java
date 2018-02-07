package com.ubicompsystem.integration.google.hotelads.hotelfeed.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class FeedWebConfig 
	implements WebApplicationInitializer
{
	public void onStartup(ServletContext container ) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		ContextLoaderListener contextListener = new ContextLoaderListener(rootContext);
		container.addListener(contextListener);
		
		Dynamic dispatcher = container.addServlet( "dispatcher", new DispatcherServlet(rootContext));
		dispatcher.addMapping("/");
		
	}
}
