# encoder

* **프로젝트 소개**
```
	*. 자주 사용하는 인코딩(암,복호화 등) 기능 구현
```

----

* **클래스 구조**
![](/encoder/images/class.png)

-----

* **테스트 코드**
```
@Test
public void test() throws EncodingException {
	
	String src = "wkkim";
	
	/* EncoderType = [BASE64, AES256, SHA256, File, ...] */
	Encoder encoder = encoderFactory.getEncoder(EncoderType.BASE64);
	
	String encoded = encoder.encode(src);		// encoded = "d2traW0="
	String decoded = encoder.decode(encoded);	// decoded = "wkkim"
	
	assertEquals(src, decoded);
}
```
-----
