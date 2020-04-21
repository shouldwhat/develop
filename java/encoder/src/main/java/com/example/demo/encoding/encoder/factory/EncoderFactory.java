package com.example.demo.encoding.encoder.factory;

import com.example.demo.encoding.encoder.EncoderType;
import com.example.demo.encoding.encoder.base.Encoder;

public interface EncoderFactory {

	public Encoder getEncoder(EncoderType type);
}
