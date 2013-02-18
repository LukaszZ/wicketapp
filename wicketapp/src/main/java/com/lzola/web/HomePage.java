package com.lzola.web;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.SimpleFormComponentLabel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;

import com.lzola.dao.RezerwaMiesiecznaDao;
import com.lzola.domain.RezerwaMiesieczna;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private RezerwaMiesiecznaDao rezerwaMiesiecznaDao;
	
	private String numerSzkody;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
		final FeedbackPanel feedback = new FeedbackPanel("feedback");
        feedback.setOutputMarkupId(true);
        add(feedback);

        // add form with markup id setter so it can be updated via ajax
        Form<Void> form = new Form<Void>("form");
        add(form);
        form.setOutputMarkupId(true);

        

        // add form components to the form as usual

        FormComponent<String> fc = new RequiredTextField<String>("numerSzkody", new PropertyModel<String>(this, "numerSzkody"));
        fc.add(StringValidator.minimumLength(4));
        fc.setLabel(new ResourceModel("label.name"));

        form.add(fc);
        form.add(new SimpleFormComponentLabel("name-label", fc));

        // add a button that can be used to submit the form via ajax
        form.add(new AjaxButton("ajax-button", form) {
			private static final long serialVersionUID = 1L;

			@Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                // repaint the feedback panel so that it is hidden
				RezerwaMiesieczna rezerwaMiesiecznaDlaSzkody = rezerwaMiesiecznaDao.findByNumerSzkody(numerSzkody);
                target.add(feedback);
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form)
            {
                // repaint the feedback panel so errors are shown
                target.add(feedback);
            }
        });
    }
}