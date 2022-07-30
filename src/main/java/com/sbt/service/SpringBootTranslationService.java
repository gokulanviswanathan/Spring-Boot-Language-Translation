/**
 * 
 */
package com.sbt.service;

import com.sbt.dto.MessageResponseDto;

public interface SpringBootTranslationService {

	MessageResponseDto getTranslatedText(String text);
}
