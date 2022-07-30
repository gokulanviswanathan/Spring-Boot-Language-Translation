package com.sbt.dto;

import java.io.Serializable;

public class MessageRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3180810712632203586L;
	
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
