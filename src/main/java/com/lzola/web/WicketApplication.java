package com.lzola.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.lzola.web.home.HomePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 */
public class WicketApplication extends WebApplication {    	
	
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	@Override
	public void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		
//		mount(new QueryStringUrlCodingStrategy("home", HomePage.class);
	}
}
