package com.ubicompsystem.integration.google.hotelads.hotelfeed.config;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ubicompsystem.common.exception.BaseException;
import com.ubicompsystem.core.property.service.PropertyService;
import com.ubicompsystem.data.property.PropertyData;

public class FeedWebConfig 
	implements WebApplicationInitializer
{
	public void onStartup(ServletContext container ) throws ServletException {
		
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath*:resources/spring/applicationContext.xml");
		
		System.out.println( "*********************** FEEDWEBCONFIG ****************************" );
		System.out.println( xmlContext.getBean( "propertyService" ) );
		PropertyService propertyService = (PropertyService) xmlContext.getBean("propertyService");
		try {
			System.out.println( propertyService.getList( new PropertyData(), new ArrayList<String>() ) );
		} catch( BaseException baseEx ) {
			baseEx.printStackTrace( System.out );
		}
		
		System.out.println( "*********************** FEEDWEBCONFIG ****************************" );
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.setParent(xmlContext);
		rootContext.register(FeedConfig.class);
		
		ContextLoaderListener contextListener = new ContextLoaderListener(rootContext);
		container.addListener(contextListener);
		
		Dynamic dispatcher = container.addServlet( "dispatcher", new DispatcherServlet(rootContext));
		dispatcher.addMapping("/");
		
	}
}
