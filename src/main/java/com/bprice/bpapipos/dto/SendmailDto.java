package com.bprice.bpapipos.dto;

import java.util.List;

public class SendmailDto {

	private String[] sendto;
    private String subject;
    private String text;
	public SendmailDto(String[] sendto, String subject, String text) {
		super();
		this.sendto = sendto;
		this.subject = subject;
		this.text = text;
	}
	
	public String[] getSendto() {
		return sendto;
	}

	public void setSendto(String[] sendto) {
		this.sendto = sendto;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

   

}
