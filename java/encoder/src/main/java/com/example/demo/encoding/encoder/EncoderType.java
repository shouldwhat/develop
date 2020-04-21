package com.example.demo.encoding.encoder;

public enum EncoderType {

	BASE64("base64Encoder"),
	FILE("fileEncoder"),
	SHA256("sha256Encoder"),
	AES256("aes256Encoder"),
	;
	
	private final String value;
	EncoderType(String value) { this.value = value; }
    public String value() { return this.value; }
    
    @Override
    public String toString() { return this.value; }
}
