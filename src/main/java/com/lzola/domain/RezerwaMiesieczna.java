package com.lzola.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RezerwaMiesieczna {

	@Id
	@Column
	private String numerSzkody;
	@Column
	private String typRezerwy;
	@Column
	private String rodzajRezerwy;
	@Column
	@Temporal(TemporalType.DATE)
	private Date miesiac;
	
	public String getNumerSzkody() {
		return numerSzkody;
	}
	public void setNumerSzkody(String numerSzkody) {
		this.numerSzkody = numerSzkody;
	}
	public String getTypRezerwy() {
		return typRezerwy;
	}
	public void setTypRezerwy(String typRezerwy) {
		this.typRezerwy = typRezerwy;
	}
	public String getRodzajRezerwy() {
		return rodzajRezerwy;
	}
	public void setRodzajRezerwy(String rodzajRezerwy) {
		this.rodzajRezerwy = rodzajRezerwy;
	}
	public Date getMiesiac() {
		return miesiac;
	}
	public void setMiesiac(Date miesiac) {
		this.miesiac = miesiac;
	}
}
