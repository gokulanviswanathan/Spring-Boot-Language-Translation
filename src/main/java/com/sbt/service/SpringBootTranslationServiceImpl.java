package com.sbt.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.sbt.dto.MessageResponseDto;

@Service
public class SpringBootTranslationServiceImpl implements SpringBootTranslationService {

	private static final String SINGLE_WHITESPACE = " ";

	private static final String HELLO = "HELLO_MESSAGE";

	private static final Logger logger = LogManager.getLogger(SpringBootTranslationServiceImpl.class);

	@Autowired
	MessageSource messageSource;

	public MessageResponseDto getTranslatedText(String text) {
		logger.info("Inside getTranslatedText method::Text:: {}", text);
		MessageResponseDto responseDto = new MessageResponseDto();
		responseDto.setText(text);
		responseDto.setTranslatedText(processTranslation(HELLO).concat(SINGLE_WHITESPACE).concat(text));
		return responseDto;
	}

	public String processTranslation(String text) {
		String response = text;
		try {
			response = messageSource.getMessage(text, null, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			logger.error("Exception occured while processing the translation, errorMessage:: {}", e.getMessage());
		}
		return response;
	}
}