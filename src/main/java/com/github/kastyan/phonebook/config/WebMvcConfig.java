package com.github.kastyan.phonebook.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration

public class WebMvcConfig extends WebMvcConfigurerAdapter{
	private static final String VIEWS = "/WEB-INF/views/";
	/*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

    }*/
 	 @Bean
	    public TemplateResolver templateResolver() {
	        TemplateResolver templateResolver = new ServletContextTemplateResolver();
	        templateResolver.setPrefix(VIEWS);
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode("HTML5");
	        templateResolver.setCacheable(false);
	        return templateResolver;
	    }

	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	    }

	    @Bean
	    public ThymeleafViewResolver viewResolver() {
	        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
	        thymeleafViewResolver.setTemplateEngine(templateEngine());
	        thymeleafViewResolver.setCharacterEncoding("UTF-8");
	        return thymeleafViewResolver;
	    }
	    
 }
