package symmetrical;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainAES{
	
	public static void main(String[] args) {
		
	
	try {
		
		
		// Obtain the key generator
		
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		
	
		// The symmetric key will be generated
		
		SecretKey sk = generator.generateKey();
		
		
		
		// This object allows to encrypt or decrypt using a key
		
		Cipher cpr = Cipher.getInstance("AES");
		
		
		// Now it will be configured the encryptor to use the symmetric key	
		
		cpr.init(Cipher.ENCRYPT_MODE, sk);		
					
		String originalMessage = "With great power comes great responsibility";
		
		
		
		// The encryptor works with bytes, it will be converted	
		
		byte[] bytesOriginalMessage = originalMessage.getBytes();
		
		
		
		
		// The encryptor returns a string of bytes
		
		byte[] bytesEncryptedMessage = cpr.doFinal(bytesOriginalMessage);
		String encryptedMessage = new String(bytesEncryptedMessage);
		
		
		System.out.println("Original message: " + originalMessage);
		System.out.println("Encrypted Message: " + encryptedMessage);
		
		
		//A decryptor will now be configured to use the symmetric key to decrypt. 
		// The SAME key must be used to decrypt, you CANNOT generate or use a different one.
		
		Cipher decoder = Cipher.getInstance("AES");
		decoder.init(Cipher.DECRYPT_MODE, sk);
		byte[] bytesDecryptedMessage = decoder.doFinal(bytesEncryptedMessage);
		System.out.println("Decrypted Message: " + new String(bytesDecryptedMessage));
		
		
	//Exceptions are simplified by catching GeneralSecurityException
		
	} catch (GeneralSecurityException gse) {
		
		System.out.println("Something has gone wrong..." + gse.getMessage());
		
		gse.printStackTrace();
		
	}
	
}


}
