package fr.treeptik.pizzaiolo2.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigurer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfiguration.class);
		rootContext.setServletContext(servletContext);
		rootContext.refresh();

		initSpring(servletContext, rootContext);
	}

	private ServletRegistration.Dynamic initSpring(
			ServletContext servletContext,
			AnnotationConfigWebApplicationContext rootContext) {
		AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
		dispatcherServletConfiguration.setParent(rootContext);
		dispatcherServletConfiguration
				.register(DispatcherServletConfiguration.class);
		ServletRegistration.Dynamic dispatcherServlet = servletContext
				.addServlet("dispatcher", new DispatcherServlet(
						dispatcherServletConfiguration));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
		return dispatcherServlet;
	}
}