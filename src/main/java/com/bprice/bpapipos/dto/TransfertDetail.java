/*
 * creer par Oussama dridi 10 sept. 2021
 */
package com.bprice.bpapipos.dto;

import java.util.List;

public class TransfertDetail {

	private String idTableSrc;
	private String idTableDes;
	private List<String> ids;

	public TransfertDetail(String idTableSrc, String idTableDes, List<String> ids) {
		super();
		this.idTableSrc = idTableSrc;
		this.idTableDes = idTableDes;
		this.ids = ids;
	}

	
	public TransfertDetail() {
		super();
	}


	public String getIdTableSrc() {
		return idTableSrc;
	}

	public String getIdTableDes() {
		return idTableDes;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIdTableSrc(String idTableSrc) {
		this.idTableSrc = idTableSrc;
	}

	public void setIdTableDes(String idTableDes) {
		this.idTableDes = idTableDes;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
