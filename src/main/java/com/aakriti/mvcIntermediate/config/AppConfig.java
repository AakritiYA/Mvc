package com.aakriti.mvcIntermediate.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.aakriti.mvcIntermediate.formatter.PhoneFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.aakriti.mvcIntermediate")
@PropertySource("classpath:email.properties")  // for tell the spring we use this property file name
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private  Environment env; // reference so that we set the data from property file
	
//	set up my view Resolver

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean // from line 33 to 50 we just do for create our own validator like @Notblank
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	public Validator getValidator() {
		return validator();
	}

	@Bean
	public JavaMailSenderImpl getJavaMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		System.out.println(".................." );
		
		javaMailSenderImpl.setHost(env.getProperty("mail.host")); // instead of hard code we set the value from property file
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));

		Properties mailProperties = getEmailProperty(); //yha pr property ko nhi likhe hai function ke through call kiye hai

		javaMailSenderImpl.setJavaMailProperties(mailProperties);

		return javaMailSenderImpl;
	}

	private Properties getEmailProperty() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.provider", "com.sun.mail.smtp.SMTPProvider");
		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.ssl.trust", "*");
		mailProperties.put("mail.debug", "true");
		mailProperties.put("mail.transport.protocol", "smtp");
		mailProperties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		mailProperties.put("mail.smtp.ssl.enable", "true");
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		return mailProperties;
	}

	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PhoneFormatter());
	}

}
