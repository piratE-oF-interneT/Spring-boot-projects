package com.uber;

import com.uber.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		
		emailSenderService.sendEmail("celepic952@owlny.com" , "this is test email" , "jhdfbvcbdfcbnjesbndjhenshbchsdbhfbdshbjsbhubwshcbsdbhbshbchdbshjbdshfbdshbfhdsbhbdshbfhdsbfdbshfhdbfhdbfhdsbhjdhfsbhfsdb");

		
	}

}
