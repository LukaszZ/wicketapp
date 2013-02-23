package com.lzola.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RezerwaMiesiecznaKey implements Serializable {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -4915275465031778352L;

	@Column
	private String numerSzkody;
	@Column
	private Integer rok;
	@Column
	private Integer miesiac;
	@Column
	private String typRezerwy;
	
	public String getNumerSzkody() {
		return numerSzkody;
	}
	public void setNumerSzkody(String numerSzkody) {
		this.numerSzkody = numerSzkody;
	}
	public Integer getRok() {
		return rok;
	}
	public void setRok(Integer rok) {
		this.rok = rok;
	}
	public Integer getMiesiac() {
		return miesiac;
	}
	public void setMiesiac(Integer miesiac) {
		this.miesiac = miesiac;
	}
	public String getTypRezerwy() {
		return typRezerwy;
	}
	public void setTypRezerwy(String typRezerwy) {
		this.typRezerwy = typRezerwy;
	}
	
}
