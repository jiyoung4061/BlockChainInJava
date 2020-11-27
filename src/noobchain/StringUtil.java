package noobchain;

import java.security.MessageDigest; // SHA256�˰��� �����ϱ� ����
//SHA256�˰���?
//�̱� ǥ�� ��� �����ҿ� ���� ��ǥ�� ǥ�� �ؽ� �˰���
//256��Ʈ�� �����Ǿ� 64�ڸ� ���ڿ��� ��ȯ
//256��Ʈ = 2^256���� ����� ���� �ؽ� �浹�� ������ ����

public class StringUtil {
	public static String applySha256(String input) {
		// �ϳ��� ���ڿ��� �޾� �ű⿡ SHA256�˰����� �����Ŵ!
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for(int i = 0 ; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString(); // �ٲ� ���ڿ��� return����
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
