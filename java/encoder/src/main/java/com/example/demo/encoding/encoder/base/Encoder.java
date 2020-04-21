package com.example.demo.encoding.encoder.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.encoding.exception.EncodingException;

public abstract class Encoder<T> {

	protected static final Logger LOG = LoggerFactory.getLogger(Encoder.class);
	
	protected abstract String _encode(T src);
	protected abstract String _decode(String encoded);
	
	private Class<T> genericClassType() {
		
		Type superClass = this.getClass().getGenericSuperclass();
		Type typeClass = (((ParameterizedType) superClass).getActualTypeArguments())[0];
		
		return (Class<T>) typeClass;
	}

	public String encode(Object src) throws EncodingException {
		
		if(src == null) { 
			return null; 
		}
		
		if( !this.genericClassType().isInstance(src)) {
			
			LOG.debug(" src = {}, expect type = {}", src.getClass(), this.genericClassType());
			throw new EncodingException("not support src type");
		}
		
		return this._encode((T) src);
	}
	
	public String decode(String encoded) {
		return this._decode(encoded);
	}
}
