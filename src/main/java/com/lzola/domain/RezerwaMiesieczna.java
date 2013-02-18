package com.lzola.domain;

import java.math.BigDecimal;
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
	private Long id;
	@Column
	private String numerSzkody;
	@Column
	private String typRezerwy;
	@Column
	private String rodzajRezerwy;
	@Column
	@Temporal(TemporalType.DATE)
	private Date miesiac;
	@Column
	private BigDecimal wartosc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public BigDecimal getWartosc() {
		return wartosc;
	}
	public void setWartosc(BigDecimal wartosc) {
		this.wartosc = wartosc;
	}
	
}
