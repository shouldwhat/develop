package com.example.demo.encoding.encoder;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.example.demo.encoding.encoder.base.Encoder;

@Component("aes256Encoder")
public class AES256Encoder extends Encoder<String> {

	private Cipher cipher = null;
	
	private Key key = null;
	
	public AES256Encoder() throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		this.key = this.getRandomKey();
		this.cipher = Cipher.getInstance("AES");
//		key = this.getKeyAtKeystore();
		
	}
	
	private Key getKeyAtKeystore() {
		// TODO Auto-generated method stub
		return null;
	}

	private Key getRandomKey() throws UnsupportedEncodingException {
		
		String seed = "ase256cipher-key";
		
		return new SecretKeySpec(seed.getBytes("UTF-8"), "AES");
	}

	@Override
	protected String _encode(String src) {
		
		byte[] output = null;
		
		try {
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
			output = cipher.doFinal(src.getBytes("UTF-8"));
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new String(Base64.encodeBase64(output));
	}

	@Override
	protected String _decode(String encoded) {
		
		String output = null;
		
		try {
			
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decoded = cipher.doFinal(Base64.decodeBase64(encoded.getBytes()));
			
			output = new String(decoded, "UTF-8");
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return output;
	}

}
