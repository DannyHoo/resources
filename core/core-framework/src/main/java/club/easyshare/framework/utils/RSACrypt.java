package club.easyshare.framework.utils;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSACrypt {

	public static void main(String[] args) throws Exception {
		//初始化阶段
		HashMap<String, String> map = RSACrypt.getKeys();
		String privateKeyStr=map.get("privateKey");
		String publicKeyStr=map.get("publicKey");
		System.out.println("初始化私钥为："+privateKeyStr);
		System.out.println("初始化共钥为："+publicKeyStr);
		//http发送方（Client）
		String originData="周末约你看电影吧";
		System.out.println("信息原文："+originData);
		String encryptData=RSACrypt.encrypt(RSACrypt.loadPublicKey(publicKeyStr),originData.getBytes());
		System.out.println("加密后："+encryptData);
		//http接收方（Server）
		String decryptData=RSACrypt.decrypt(RSACrypt.loadPrivateKey(privateKeyStr),RSACrypt.strToBase64(encryptData));
		System.out.println("解密后："+decryptData);

		/*String miyao="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJKc2JrdrfLXfjl7hGBza8n+W/Hkq8ypEd7otByGfcqIX1z+y2Atfyxb9DCFAap5M/5VTFNXkgVxdZcMI0glbKQsNuu4VxRTwlAd6wDfINtdUCuy2pO8uq65behljhJwhqLjs74LTLvIysDNhxWFmTjWA4x5ivjGqRW1z7hSeZJRAgMBAAECgYB0o9njo1dfareeLblMLqdjhTxK/pz7bsqr58BbLVhoSARubLsKYkfZ17I246pGoLSPs/bMG1Atim195Qcwv61k1qbUqNCXDDlCjHcvyZ/AexOuc5KIKQ53Jl4iry58HhrqDkAMlZc1NKELFc/Y6Cmxn9iNgwEWsJU0A1SVRZOPwQJBAPSaYpm5ENwiYJHc0O02jFDJeTtcWoHcsx47qhknQKbc3c6xEjn5VQpi8kb/ulQilRiq4DhbmmbuqHR+n7Dh4rkCQQCZcaLGnWzOap1hYSE+2gCX+REk5d559jtpcTudtal6oyfFdDbxZMnaGe+xZJhbP8Rb1DXeN5MeRjDIE8rhn8BZAkEAk0W9JjcyOoiMQmaEeL7GHwIfdyk06UmboxFjaf+jQpRrDD667aL8m+NVYoAojO3BfXesxuIIhf8d9/4hYhuvKQJAFxx9hurJK6H1SGiHyF6vfjRed69DvhzvP+d1MkDdYQJYCC6D5AHpQTds2cwsAnptSeOBpZG7T/EEge4xPaCBKQJAUUGJFAGx+wDYl8oEaLoC4M5XUe7gQFV8F9+tt8nOcZecnUF31ngYsg7TJ6YDF1XiGrUyA5NJAg7/1oJ0fYWUrQ==";
		String mima="OZEvJ6zzWyuFICxLmK6odiGz7dauAUIFbX4V/HxeBNHMD/xd5FuB6sWl08W/9MVfwqOxQMVvozCy884PbTrRPD4iizqfplzfDYumW0hqBix7P6glm0F3O20bpq8eZH1HksuNj7eunu9ShiHEVk+sH+76lQPqdwSy13AzhDEnkLY=";
		String jiemi=RSACrypt.decrypt(RSACrypt.loadPrivateKey(miyao), RSACrypt.strToBase64(mima));
		String password = "qazwsx123当前线程上";
		//在第一次请求时生成公钥与私钥，并放到当前线程上。返回公钥给客户端。
		//session.setAttribute("PD_CurrentRSAKey", map);
		HashMap<String, String> map = RSACrypt.getKeys();
		try{
			//从session上拿到上次生成的密钥
			RSAPublicKey publicKey = RSACrypt.loadPublicKey(map.get("publicKey"));
			RSAPrivateKey privateKey = RSACrypt.loadPrivateKey(map.get("privateKey"));
			System.out.println("公钥："+map.get("publicKey"));
			System.out.println("私钥："+map.get("privateKey"));
			System.out.println("明文："+password);
			//使用私钥解密传输过来的密码
			String passwordjiam = RSACrypt.encrypt(publicKey, password.getBytes());
			System.out.println("加密后："+passwordjiam);
			String passwordJiem = RSACrypt.decrypt(privateKey, RSACrypt.strToBase64(passwordjiam));
			System.out.println("解密后："+passwordJiem);
		}catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 生成RAS公钥与私钥字符串，直接返回
	 * 
	 * @return
	 */
	public static HashMap<String, String> getKeys() {
		HashMap<String, String> map = new HashMap<String, String>();
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 初始化密钥对生成器，密钥大小为96-1024位
		keyPairGen.initialize(1024, new SecureRandom());
		// 生成一个密钥对，保存在keyPair中
		KeyPair keyPair = keyPairGen.generateKeyPair();
		// 得到公钥字符串
		String publicKey = base64ToStr(keyPair.getPublic().getEncoded());
		// 得到私钥字符串
		String privateKey = base64ToStr(keyPair.getPrivate().getEncoded());
		map.put("publicKey", publicKey);
		map.put("privateKey", privateKey);
		return map;
	}

	/**
	 * 从字符串中加载公钥
	 * 
	 * @param publicKeyStr
	 *            公钥字符串
	 * @return
	 * @throws Exception
	 */
	public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
		try {
			byte[] buffer = javax.xml.bind.DatatypeConverter.parseBase64Binary(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法", e);
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法", e);
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空", e);
		}
	}

	/**
	 * 从字符串中加载私钥
	 * 
	 * @param privateKeyStr
	 *            私钥字符串
	 * @return
	 * @throws Exception
	 */
	public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
		try {
			byte[] buffer = javax.xml.bind.DatatypeConverter.parseBase64Binary(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法", e);
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法", e);
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空", e);
		}
	}

	/**
	 * 公钥加密过程
	 * 
	 * @param publicKey
	 *            公钥
	 * @param plainTextData
	 *            明文数据
	 * @return
	 * @throws Exception
	 *             加密过程中的异常信息
	 */
	public static String encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
		if (publicKey == null) {
			throw new Exception("加密公钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] output = cipher.doFinal(plainTextData);
			return base64ToStr(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此加密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("加密公钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("明文长度非法");
		} catch (BadPaddingException e) {
			throw new Exception("明文数据已损坏");
		}
	}

	/**
	 * 私钥加密过程
	 * 
	 * @param privateKey
	 *            私钥
	 * @param plainTextData
	 *            明文数据
	 * @return
	 * @throws Exception
	 *             加密过程中的异常信息
	 */
	public static String encrypt(RSAPrivateKey privateKey, byte[] plainTextData) throws Exception {
		if (privateKey == null) {
			throw new Exception("加密私钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] output = cipher.doFinal(plainTextData);
			return base64ToStr(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此加密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("加密私钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("明文长度非法");
		} catch (BadPaddingException e) {
			throw new Exception("明文数据已损坏");
		}
	}

	/**
	 * 私钥解密过程
	 * 
	 * @param privateKey
	 *            私钥
	 * @param cipherData
	 *            密文数据
	 * @return 明文
	 * @throws Exception
	 *             解密过程中的异常信息
	 */
	public static String decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
		if (privateKey == null) {
			throw new Exception("解密私钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] output = cipher.doFinal(cipherData);
			return new String(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此解密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("解密私钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new Exception("密文长度非法");
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new Exception("密文数据已损坏");
		}
	}

	/**
	 * 公钥解密过程
	 * 
	 * @param publicKey
	 *            公钥
	 * @param cipherData
	 *            密文数据
	 * @return 明文
	 * @throws Exception
	 *             解密过程中的异常信息
	 */
	public static String decrypt(RSAPublicKey publicKey, byte[] cipherData) throws Exception {
		if (publicKey == null) {
			throw new Exception("解密公钥为空, 请设置");
		}
		Cipher cipher = null;
		try {
			// 使用默认RSA
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			byte[] output = cipher.doFinal(cipherData);
			return new String(output);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此解密算法");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {
			throw new Exception("解密公钥非法,请检查");
		} catch (IllegalBlockSizeException e) {
			throw new Exception("密文长度非法");
		} catch (BadPaddingException e) {
			throw new Exception("密文数据已损坏");
		}
	}

	public static String base64ToStr(byte[] b) {
		return javax.xml.bind.DatatypeConverter.printBase64Binary(b);
	}

	public static byte[] strToBase64(String str) {
		return javax.xml.bind.DatatypeConverter.parseBase64Binary(str);
	}
}
