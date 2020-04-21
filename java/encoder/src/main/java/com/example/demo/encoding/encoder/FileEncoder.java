package com.example.demo.encoding.encoder;

import java.io.File;

import org.springframework.stereotype.Component;

import com.example.demo.encoding.encoder.base.Encoder;

@Component("fileEncoder")
public class FileEncoder extends Encoder<File> {

	@Override
	protected String _encode(File src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String _decode(String encoded) {
		// TODO Auto-generated method stub
		return null;
	}

}
