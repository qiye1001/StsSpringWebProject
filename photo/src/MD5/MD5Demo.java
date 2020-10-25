package MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MD5Demo {
	private static String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ=="; // 储存的密文

	public static void main(String[] args) {

		System.out.println(login("admin123456"));
	}

	public static boolean login(String password) {
		if (savePassword.equals(md5(password))) {
			return true;
		} else {
			return false;
		}
	}

	public static String md5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(password.getBytes("utf-8")); // 摘要 (无法回到原文)
			password = new String(bytes);
			String encodeStr = Base64.getEncoder().encodeToString(bytes); // 对摘要进行编码
			System.out.println(encodeStr);
			return encodeStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
