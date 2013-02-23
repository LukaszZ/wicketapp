package com.lzola.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.resolver.AutoLinkResolver.AutolinkBookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.lzola.web.contact.ContactPage;
import com.lzola.web.examples.ExamplesPage;
import com.lzola.web.home.HomePage;
import com.lzola.web.rezerwa.RezerwaMiesiecznaPage;
import com.lzola.web.rezerwa.RezerwaRocznaPage;

public abstract class AppBasePage extends WebPage{

	protected FeedbackPanel feedback;
	private Map<Class, WebMarkupContainer> linki = new HashMap<Class, WebMarkupContainer>();
	
	public AppBasePage() {
		this(null);
	}
	
	public AppBasePage(PageParameters parameters) {
		addFeedback();
		addMenuLinks();
		markLinkAsSelected();
	}
	
	private void markLinkAsSelected() {
		Class clazz = this.getClass();
		WebMarkupContainer webMarkupContainer = linki.get(clazz);
		webMarkupContainer.add(new AttributeModifier("class", "selected"));
	}

	private void addMenuLinks() {
		AutolinkBookmarkablePageLink.autoEnable = false;
		
		WebMarkupContainer home = new WebMarkupContainer("home");
		WebMarkupContainer rezerwa = new WebMarkupContainer("rezerwa");
		WebMarkupContainer examples = new WebMarkupContainer("examples");
		WebMarkupContainer contact = new WebMarkupContainer("contact");
		
		linki.put(HomePage.class, home);
		linki.put(RezerwaMiesiecznaPage.class, rezerwa);
		linki.put(RezerwaRocznaPage.class, rezerwa);
		linki.put(ExamplesPage.class, examples);
		linki.put(ContactPage.class, contact);
		
		add(home);
		add(rezerwa);
		add(examples);
		add(contact);
	}

	private void addFeedback() {
		add(feedback = new FeedbackPanel("feedback"));
		feedback.setOutputMarkupId(true);
	}

}
