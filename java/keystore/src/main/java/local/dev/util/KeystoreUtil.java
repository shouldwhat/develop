package local.dev.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;

public class KeystoreUtil
{
	private Logger logger = LoggerFactory.getLogger(KeystoreUtil.class);
	
	/***
	 * 인증서 파일 import 하여, 자바에서 핸들링 가능한 X509Certificate Object로 변경한다.
	 * @param certFile
	 * @return
	 * @throws FileNotFoundException 
	 * @throws CertificateException 
	 */
	public static X509Certificate getCertificate(File certFile) throws FileNotFoundException, CertificateException
	{
		X509Certificate cert = null;
		
		FileInputStream fis = new FileInputStream(certFile);
		
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
		
		cert = (X509Certificate) certificateFactory.generateCertificate(fis);
		
		return cert;
	}
	
	/***
	 * X509Certificate Object에서 해당 인증서의 공개키를 추출한다. 
	 * @param certFile
	 * @return
	 * @throws CertificateException 
	 * @throws FileNotFoundException 
	 */
	public static PublicKey getPublicKey(File certFile) throws FileNotFoundException, CertificateException
	{
		PublicKey publicKey = null;
		X509Certificate cert = null;
		
		cert = KeystoreUtil.getCertificate(certFile);
		
		publicKey = cert.getPublicKey();
		
		return publicKey;
	}
	/***
	 * Keystore에서 alias로 저장된 키를 Object로 조회한다.
	 * @param keyStoreFile
	 * @param keyStoreType
	 * @param alias
	 * @param password
	 * @return
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws UnrecoverableKeyException
	 */
	public static Key getKeyObject(File keyStoreFile, String keyStoreType, String alias, String password) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException
	{
		Key key = null;
		
		FileInputStream fis = new FileInputStream(keyStoreFile);
		
		/* JCEKS = Java Cryptography Extension Keystore */
		/* JCEKS 타입의 KeyStore Get */
		/* KeyStore Load */
		KeyStore keyStore = KeyStore.getInstance(keyStoreType);
		keyStore.load(fis, password.toCharArray());
		
		/* 'ntreevaes' 알리아스를 가지는 Key Get */
		key = keyStore.getKey(alias, password.toCharArray());
		
		return key; 
	}
	
	/***
	 * Keystore에서 alias로 저장된 키를 String 값으로 조회한다.
	 * @param jcekFile
	 * @param keyStoreType
	 * @param alias
	 * @param password
	 * @return
	 * @throws UnrecoverableKeyException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static String getKeyString(File jcekFile, String keyStoreType, String alias, String password) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
	{
		Key key = KeystoreUtil.getKeyObject(jcekFile, keyStoreType, alias, password);
		
		return new BASE64Encoder().encode(key.getEncoded());
	}
	
	private void test()
	{
		File file = new File("C:\\application\\apache\\apache-tomcat-8.0.33\\keystore\\ssl-keystore.jks");
//		File file = new File("C:\\Users\\Administrator\\Desktop\\signCert.der");
		
		try
		{
			logger.info("*********************************************************************");
//			logger.info("**************** cert = {}", KeystoreUtil.getCertificate(file));
//			logger.info("**************** cert = {}", KeystoreUtil.getPublicKey(file));
			
//			PublicKey publicKey = KeystoreUtil.getPublicKey(file);
			
//			logger.info("******************************************* format = {}", publicKey.getFormat());
//			logger.info("******************************************* encoded = {}", publicKey.getEncoded());
			
						
//			Provider[] providers = Security.getProviders();
//			
//			for(int n=0; n<providers.length; n++)
//			{
//				String name = providers[n].getName();
//				String info = providers[n].getInfo();
//				double version = providers[n].getVersion();
//				logger.info("----------------------------------------");
//				logger.info("--- name : {}", name);
//				logger.info("--- info : {}", info);
//				logger.info("--- version : {}", version);
//				
//				for(Object key : providers[n].keySet())
//				{
//					logger.info("------------- key = {}", providers[n].getProperty(key.toString()));
//				}
//			}
			
			logger.info("************************* key = {}", KeystoreUtil.getKeyString(file, "JCEKS", "ntreevaes", "master"));
			
//			KeystoreUtil.getPublicKey(file);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new KeystoreUtil().test();
	}
	
}
