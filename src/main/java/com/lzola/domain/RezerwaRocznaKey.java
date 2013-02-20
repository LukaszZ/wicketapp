package com.lzola.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RezerwaRocznaKey implements Serializable {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -4915275465031778352L;
	
	@Column
	private String numerSzkody;
	@Column
	private Integer rok;

	public RezerwaRocznaKey() {
		
	}
	
	public RezerwaRocznaKey(String numerSzkody, Integer rok) {
		this.numerSzkody = numerSzkody;
		this.rok = rok;
	}
	
	public String getNumerSzkody() {
		return numerSzkody;
	}
	public Integer getRok() {
		return rok;
	}
	
	
}
