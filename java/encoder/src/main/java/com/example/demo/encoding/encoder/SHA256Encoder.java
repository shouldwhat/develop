package com.example.demo.encoding.encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import com.example.demo.encoding.encoder.base.Encoder;

@Component("sha256Encoder")
public class SHA256Encoder extends Encoder<String> {

	private MessageDigest encoder = null;
	
	public SHA256Encoder() throws NoSuchAlgorithmException {
		this.encoder = MessageDigest.getInstance("SHA-256");
	}
	
	@Override
	protected String _encode(String src) {
		
		StringBuffer buffer = new StringBuffer();

		try {

			byte[] digest = this.encoder.digest(src.getBytes("UTF-8"));
			for(byte b : digest) {
				buffer.append(Integer.toHexString(0xff & b));
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return buffer.toString();
	}

	@Override
	protected String _decode(String encoded) {
		return "Hash algorithm can not decode.";
	}


}
