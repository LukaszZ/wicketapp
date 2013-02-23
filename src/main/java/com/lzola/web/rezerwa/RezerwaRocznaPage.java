package com.lzola.web.rezerwa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.springframework.util.CollectionUtils;

import com.lzola.dao.RezerwaRocznaDao;
import com.lzola.domain.RezerwaRoczna;
import com.lzola.domain.RezerwaRocznaKey;
import com.lzola.web.AppBasePage;

public class RezerwaRocznaPage extends AppBasePage {

	@SpringBean
	private RezerwaRocznaDao rezerwaRocznaDao;
	
	private RezerwaRocznaKey rocznaKey = new RezerwaRocznaKey();
	private List<RezerwaRoczna> listaRezerwRocznych = new ArrayList<RezerwaRoczna>();
	
	private WebMarkupContainer wmc;
	
	public RezerwaRocznaPage() {
		this(null);
	}
	
	public RezerwaRocznaPage(PageParameters parameters) {
		Form<Void> form = new Form<Void>("form");
		form.setOutputMarkupId(true);
		add(form);
		
		
		RequiredTextField<String> requiredNumerSzkody = new RequiredTextField<String>("numerSzkody", new PropertyModel<String>(this.rocznaKey, "numerSzkody"));
		requiredNumerSzkody.setMarkupId("numerSzkody");
		requiredNumerSzkody.add(StringValidator.maximumLength(15));
		requiredNumerSzkody.add(StringValidator.minimumLength(15));
		requiredNumerSzkody.add(new IstnienieRezerwyRocznejValidator(rezerwaRocznaDao));
		
		form.add(requiredNumerSzkody);
		form.add(new AjaxButton("ajax-button", form) {
			private static final long serialVersionUID = 1L;

			@Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
				
				listaRezerwRocznych.clear();
				
				List<RezerwaRoczna> findByNumerSzkody = rezerwaRocznaDao.findByNumerSzkody(rocznaKey.getNumerSzkody());
				if(!CollectionUtils.isEmpty(findByNumerSzkody)) {
					listaRezerwRocznych.addAll(findByNumerSzkody);
				}			
				
                renderujPonownieComponent(target, feedback);
               	renderujPonownieComponent(target, wmc);
                
            }

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				listaRezerwRocznych.clear();				
				renderujPonownieComponent(target, feedback);
               	renderujPonownieComponent(target, wmc);
			}
			
			
        });
		
		wmc = new WebMarkupContainer("wmc");
		wmc.setOutputMarkupId(true);
		ListView<RezerwaRoczna> lista = new ListView<RezerwaRoczna>("rezerwy", new PropertyModel<List<RezerwaRoczna>>(this, "listaRezerwRocznych")) {

			@Override
			protected void populateItem(ListItem<RezerwaRoczna> items) {
				RezerwaRoczna modelObject = items.getModelObject();
				
				items.add(new Label("pierwszaNaOdszk", BooleanUtils.toString(modelObject.getPierwszaNaOdszk(), "TAK", "NIE")));
				items.add(new Label("pierwszaKL", BooleanUtils.toString(modelObject.getPierwszaNaKL(), "TAK", "NIE")));
				items.add(new Label("rok", modelObject.getRok())); 
			}
			
		};		
		lista.setOutputMarkupId(true);
		
		wmc.add(lista);
		add(wmc);
	}
	
	private void renderujPonownieComponent(AjaxRequestTarget target, Component component) {
		target.add(component);
	}
	
}
