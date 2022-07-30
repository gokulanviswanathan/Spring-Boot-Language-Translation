package com.sbt.dto;

import java.io.Serializable;

public class MessageResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3180810712632203586L;
	
	private String text;
	
	private String translatedText;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
	
}
