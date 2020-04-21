package com.example.demo.encoding.encoder;

import java.util.Base64;

import org.springframework.stereotype.Component;

import com.example.demo.encoding.encoder.base.Encoder;

@Component("base64Encoder")
public class Base64Encoder extends Encoder<String> {

	@Override
	protected String _encode(String src) {
		return Base64.getEncoder().encodeToString(src.getBytes());
	}

	@Override
	protected String _decode(String encoded) {

		byte[] decoded = Base64.getDecoder().decode(encoded);
		return new String(decoded);
	}
}
