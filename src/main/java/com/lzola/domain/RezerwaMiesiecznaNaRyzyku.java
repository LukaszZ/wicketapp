package com.lzola.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.lzola.utils.BigDecimalUtils;

@Entity
public class RezerwaMiesiecznaNaRyzyku implements Serializable{

	/**
	 * Generated serialVersionId
	 */
	private static final long serialVersionUID = -3842569713144422760L;
	
	@Id
	@Column
	private Long id;
	@Column
	private String nazwaRyzyka;
	@Column
	private String rodzajRezerwy;
	@Column
	private BigDecimal wartosc;
	@ManyToOne
	private RezerwaMiesieczna rezerwaMiesieczna;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazwaRyzyka() {
		return nazwaRyzyka;
	}
	public void setNazwaRyzyka(String nazwaRyzyka) {
		this.nazwaRyzyka = nazwaRyzyka;
	}
	public String getRodzajRezerwy() {
		return rodzajRezerwy;
	}
	public void setRodzajRezerwy(String rodzajRezerwy) {
		this.rodzajRezerwy = rodzajRezerwy;
	}
	public BigDecimal getWartosc() {
		return wartosc;
	}
	public void setWartosc(BigDecimal wartosc) {
		this.wartosc = wartosc;
	}
	public RezerwaMiesieczna getRezerwaMiesieczna() {
		return rezerwaMiesieczna;
	}
	public void setRezerwaMiesieczna(RezerwaMiesieczna rezerwaMiesieczna) {
		this.rezerwaMiesieczna = rezerwaMiesieczna;
	}
	@Transient
	public String getWartoscAsString() {
		return BigDecimalUtils.formatToCurrency(wartosc);
	}
	
}
