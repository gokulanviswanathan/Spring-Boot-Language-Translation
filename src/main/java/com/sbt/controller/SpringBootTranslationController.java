package com.sbt.controller;

/**
 * 
 */

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.dto.MessageRequestDto;
import com.sbt.dto.MessageResponseDto;
import com.sbt.service.SpringBootTranslationService;

@RestController
@RequestMapping("/sbt")
public class SpringBootTranslationController {

	private static final Logger logger = LogManager.getLogger(SpringBootTranslationController.class);

	@Autowired
	SpringBootTranslationService springBootTranslationService;

	@PostMapping(value = "/translate", produces = "application/json")
	public ResponseEntity<MessageResponseDto> translateText(@RequestBody MessageRequestDto messageRequest)
			throws IllegalArgumentException {
		if (Objects.isNull(messageRequest) || ObjectUtils.isEmpty(messageRequest.getText())) {
			logger.info("ERROR");
			throw new IllegalArgumentException("INPUT ERROR");
		}
		logger.info("Inside translateText method::Text:: {}", messageRequest.getText());
		return new ResponseEntity<>(springBootTranslationService.getTranslatedText(messageRequest.getText()),
				HttpStatus.OK);
	}

}