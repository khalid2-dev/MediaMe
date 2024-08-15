package com.mediame.mediame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediameApplicationTests {
	
	public static Logger LOGGER = LoggerFactory.getLogger(MediameApplicationTests.class);

	@Test
	void contextLoads() {
		
		LOGGER.info("Testing TEST-1");
		
		assertEquals(true, true);
		
	}

}
