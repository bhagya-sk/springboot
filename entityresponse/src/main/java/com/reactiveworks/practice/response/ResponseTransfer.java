package com.reactiveworks.practice.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseTransfer {
	
	private String text;

	ResponseTransfer(){
		
	}
	
	public ResponseTransfer(String text) {
		this.text=text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
