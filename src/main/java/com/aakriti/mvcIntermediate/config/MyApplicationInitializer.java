package com.aakriti.mvcIntermediate.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { // register spring config class
		Class arr[] = { AppConfig.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = { "/" }; // configure mapping for dispatcher servlet
		return arr;
	}

}

/* this is one way to initialize dispatcher servlet */
//public class MyApplicationInitializer implements WebApplicationInitializer {
//
//	public void onStartup(ServletContext servletContext) throws ServletException {
//
//////		creating XmlWebApplicationContext object "container object"
//////		we use when we use xml config, if we use java class for config then please see below
////		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
////		webApplicationContext.setConfigLocation("classpath:yash-servlet.xml");
//		
////		if we use java config then we have to do this
//		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//		webApplicationContext.register(AppConfig.class);
//
////		create a dispatcher servlet object
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
//
////		register the dispatcher servlet with servlet context object
//		ServletRegistration.Dynamic myCustomDispatcherservlet = servletContext.addServlet("mydispatcherservlet",
//				dispatcherServlet);
////		ServletRegistration and Dynamic both are interface, it confirms that it will be registered dynamically during the time of deployment 
//
//		myCustomDispatcherservlet.setLoadOnStartup(1);
//		myCustomDispatcherservlet.addMapping("/mywebsite.com/*");
//
//	}
//
//}
