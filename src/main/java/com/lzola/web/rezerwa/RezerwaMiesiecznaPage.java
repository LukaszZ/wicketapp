package com.lzola.web.rezerwa;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.springframework.util.CollectionUtils;

import com.lzola.dao.RezerwaMiesiecznaDao;
import com.lzola.domain.RezerwaMiesieczna;
import com.lzola.web.AppBasePage;

public class RezerwaMiesiecznaPage extends AppBasePage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private RezerwaMiesiecznaDao rezerwaMiesiecznaDao;
	
	private String numerSzkody;	
	private List<RezerwaMiesieczna> rezerwyMiesieczne;
	private WebMarkupContainer wmc;
	
	private final ListView<RezerwaMiesieczna> listaWyszukanychRezerw;
	
	public RezerwaMiesiecznaPage(PageParameters parameters) {
        // add form with markup id setter so it can be updated via ajax
        Form<Void> form = new Form<Void>("form");
        add(form);
        form.setOutputMarkupId(true);

        // add form components to the form as usual
        FormComponent<String> requiredNumerSzkody = new RequiredTextField<String>("numerSzkody", new PropertyModel<String>(this, "numerSzkody"));
        requiredNumerSzkody.setMarkupId("numerSzkody");
        requiredNumerSzkody.add(StringValidator.maximumLength(15));
		requiredNumerSzkody.add(StringValidator.minimumLength(15));

        form.add(requiredNumerSzkody);

        // add a button that can be used to submit the form via ajax
        form.add(new AjaxButton("ajax-button", form) {
			private static final long serialVersionUID = 1L;

			@Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                // repaint the feedback panel so that it is hidden
				rezerwyMiesieczne = rezerwaMiesiecznaDao.findByNumerSzkody(numerSzkody);
                target.add(feedback);
                if (!CollectionUtils.isEmpty(rezerwyMiesieczne)) {
                	listaWyszukanychRezerw.setVisible(true);
                	target.add(wmc);
                }
            }
        });
        
        wmc = new WebMarkupContainer("wmc");
		wmc.setOutputMarkupId(true);
		
        listaWyszukanychRezerw = new ListView<RezerwaMiesieczna>("rezerwy", new PropertyModel<List<RezerwaMiesieczna>>(this, "rezerwyMiesieczne")) {
        		
			@Override
			protected void populateItem(ListItem<RezerwaMiesieczna> rezerwy) {
				RezerwaMiesieczna rez = rezerwy.getModelObject();
				
				rezerwy.add(new Label("typRezerwy", rez.getTypRezerwy()));
				rezerwy.add(new Label("rodzajRezerwy", rez.getRodzajRezerwy()));
				rezerwy.add(new Label("miesiac", rez.getMiesiac()));
				rezerwy.add(new Label("wartosc", rez.getWartosc()));
				
			}
        	
		};
		
		wmc.add(listaWyszukanychRezerw.setOutputMarkupId(true).setVisible(false));
		add(wmc);
    }
}
