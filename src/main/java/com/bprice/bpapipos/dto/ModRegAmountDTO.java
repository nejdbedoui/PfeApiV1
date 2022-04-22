/*
 * creer par Oussama dridi 10 avr. 2020
 */
package com.bprice.bpapipos.dto;

public class ModRegAmountDTO {

	private String idModReg;
	private String designation;
	private Float totale;
	private Long nombreReg;
	private short FNum;
	private short FFidelite;

	public ModRegAmountDTO() {
		super();
	}

	public ModRegAmountDTO(String idModReg, Float totale,Long nbr) {
		super();
		this.idModReg = idModReg;
		this.totale = totale;
		this.nombreReg=nbr;
	}
	
	
	

	public ModRegAmountDTO(Float totale,String designation, Long nombreReg) {
		super();
		this.designation = designation;
		this.totale = totale;
		this.nombreReg = nombreReg;
	}

	public String getIdModReg() {
		return idModReg;
	}

	public void setIdModReg(String idModReg) {
		this.idModReg = idModReg;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Float getTotale() {
		return totale;
	}

	public void setTotale(Float totale) {
		this.totale = totale;
	}

	public short getFNum() {
		return FNum;
	}

	public void setFNum(short fNum) {
		FNum = fNum;
	}

	public short getFFidelite() {
		return FFidelite;
	}

	public void setFFidelite(short fFidelite) {
		FFidelite = fFidelite;
	}

	public Long getNombreReg() {
		return nombreReg;
	}

	public void setNombreReg(Long nombreReg) {
		this.nombreReg = nombreReg;
	}



}
