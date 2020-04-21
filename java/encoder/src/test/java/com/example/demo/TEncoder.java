package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.encoding.encoder.EncoderType;
import com.example.demo.encoding.encoder.base.Encoder;
import com.example.demo.encoding.encoder.factory.EncoderFactory;
import com.example.demo.encoding.exception.EncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TEncoder {

	private static final Logger LOG = LoggerFactory.getLogger(TEncoder.class);
	
	@Autowired
	private EncoderFactory encoderFactory;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void test() {
		
		try {
			
			test(encoderFactory.getEncoder(EncoderType.BASE64));
			test(encoderFactory.getEncoder(EncoderType.AES256));
			
			testSHA256(encoderFactory.getEncoder(EncoderType.SHA256));
			
		} catch (EncodingException e) {
			e.printStackTrace();
		}
	}
	
	private void test(Encoder encoder) throws EncodingException {
		
		String src = null;
		String encoded = null;
		String decoded = null;
		
		encoded = encoder.encode(src);
		assertNull(encoded);
		LOG.debug("src = {}, encode = {}", src, encoded);
		
		src = "wkkim";
		encoded = encoder.encode(src);
		LOG.debug("src = {}, encode = {}", src, encoded);
		
		decoded = encoder.decode(encoded);
		assertEquals(src, decoded);
		LOG.debug("src = {}, decode = {}\n", src, decoded);
		
//		LOG.debug("?? = {}", encoder.encode(123));
	}
	
	private void testSHA256(Encoder encoder) throws EncodingException {
		
		String src = null;
		String encoded = null;
		
		encoded = encoder.encode(src);
		assertNull(encoded);
		
		src = "wkkim";
		encoded = encoder.encode(src);
		LOG.debug("src = {} encode = {}", src, encoded);
	}
}
