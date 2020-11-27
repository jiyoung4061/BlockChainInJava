package noobchain;

import java.security.MessageDigest; // SHA256알고리즘 접근하기 위해
//SHA256알고리즘?
//미국 표준 기술 연구소에 의해 공표된 표준 해시 알고리즘
//256비트로 구성되어 64자리 문자열을 반환
//256비트 = 2^256개의 경우의 수로 해시 충돌이 현저히 적음

public class StringUtil {
	public static String applySha256(String input) {
		// 하나의 문자열을 받아 거기에 SHA256알고리즘을 적용시킴!
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for(int i = 0 ; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString(); // 바뀐 문자열을 return해줌
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
