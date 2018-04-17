package day5b;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

	public String genHash(String hashInput) {

		byte[] bytesOfMessage;
		try {
			bytesOfMessage = hashInput.getBytes("UTF-8");

			try {
				MessageDigest md;
				md = MessageDigest.getInstance("MD5");
				byte[] thedigest = md.digest(bytesOfMessage);
				BigInteger bigInt = new BigInteger(1,thedigest);
				String hashtext = bigInt.toString(16);
				while(hashtext.length() < 32 ){
					  hashtext = "0"+hashtext;
					}
				return hashtext;

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		return "";
	}

}
