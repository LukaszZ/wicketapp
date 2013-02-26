package com.lzola.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.lzola.utils.BigDecimalUtils;

@Entity
public class RezerwaMiesieczna implements Serializable{

	/**
	 * generated serialVersionId
	 */
	private static final long serialVersionUID = -6947863986106570967L;
	
	@EmbeddedId
	private RezerwaMiesiecznaKey key;
	@Column
	private String rodzajRezerwy;	
	@Column
	private BigDecimal wartosc;
	@Column
	private String stanSzkody;
	@OneToMany(mappedBy="rezerwaMiesieczna", fetch=FetchType.EAGER)
	private List<RezerwaMiesiecznaNaRyzyku> rezerwyNaRyzyku;
	
	public List<RezerwaMiesiecznaNaRyzyku> getRezerwyNaRyzyku() {
		return rezerwyNaRyzyku;
	}
	public void setRezerwyNaRyzyku(List<RezerwaMiesiecznaNaRyzyku> rezerwyNaRyzyku) {
		this.rezerwyNaRyzyku = rezerwyNaRyzyku;
	}
	public String getNumerSzkody() {
		return key.getNumerSzkody();
	}
	public Integer getRok() {
		return key.getRok();
	}
	public Integer getMiesiac() {
		return key.getMiesiac();
	}
	public String getTypRezerwy() {
		return key.getTypRezerwy();
	}
	public RezerwaMiesiecznaKey getKey() {
		return key;
	}
	public void setKey(RezerwaMiesiecznaKey key) {
		this.key = key;
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
	public String getStanSzkody() {
		return stanSzkody;
	}
	public void setStanSzkody(String stanSzkody) {
		this.stanSzkody = stanSzkody;
	}
	@Transient
	public String getWartoscAsString() {
		return BigDecimalUtils.formatToCurrency(wartosc);
	}
	@Transient
	public String getId() {
		StringBuilder sb = new StringBuilder();
		sb.append(key.getRok()).append(key.getMiesiac()).append(key.getTypRezerwy());
		return sb.toString();
	}
}
