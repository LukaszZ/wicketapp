package com.lzola.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class RezerwaRoczna implements Serializable{

	/**
	 * Generated serialVersionId
	 */
	private static final long serialVersionUID = 6609714935111885658L;
	
	@EmbeddedId
	private RezerwaRocznaKey key;
	@Column
	private Boolean pierwszaNaOdszk;
	@Column
	private Boolean pierwszaNaKL;
	

	public String getNumerSzkody() {
		return key.getNumerSzkody();
	}
	
	public Integer getRok() {
		return key.getRok();
	}
	
	public Boolean getPierwszaNaOdszk() {
		return pierwszaNaOdszk;
	}

	public Boolean getPierwszaNaKL() {
		return pierwszaNaKL;
	}
	
}
