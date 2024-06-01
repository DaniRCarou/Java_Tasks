package symmetrical;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class MainAES{
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		
		Scanner sc = new Scanner(System.in);	
		
		int option = 0;
		
		String originalMessage = null;
					
		KeyGenerator generator = null;	
		
		SecretKey sk = null;
		
		
		byte[] bytesEncryptedMessage = new byte[0];
		
		
		
		
		
		
		// Counter for password entries		
		
		int counter = 0;		
			
		
		
		// Three users are created with the password hashed	
		
		User u1 = new User("Daniel","wJaGC+I41+Cm05Kce6BvRo0+a3soEyukjVU/hFeIxRMASx7Hh1jyTp4fAGrpqJZR+AAj9VBZJ6euzWUp+hLAgQ==");
		
		User u2 = new User("Javi","/QAc/owfqkF4xPuHrO8ClCN8qi3O7AkOSaQmgS7uqd5a+4JF4xXc+XM7Cmk+ZyqmEtkiO3NDesSvBeWWEwBx0Q==");
		
		User u3 = new User("Romario","s9W9SyTFStyH7uwUdLRsndePQBaieiqd95ESQLPXzbPB/ry9ToFSkVYMaxU9gfBcRlV2k3fdciqXm9LcvXjoUQ==");
		
		
		
		
		
	    
		do { 
			
		
		System.out.println("Enter your user name: ");
		
		String user = sc.nextLine();
		
		
		
		
		if(user.equals(u1.getUserName()) || user.equals(u1.getUserName()) || user.equals(u1.getUserName())) {
			
					
		System.out.println("Enter your password: ");
		
		
		String pass = sc.nextLine();
		
		
		
		// 1. To hash the password, the information has to be converted to bytes
		
		byte[] pass2 = pass.getBytes();
		
		
		// 2. The type of algorithm we are going to use for hashing is passed to this object
		
		MessageDigest mdP1 = MessageDigest.getInstance("SHA-512");
		
		
		// 3. The password is hashed
		
		mdP1.update(pass2);
		
		
		// 4. To convert the password to String, the information has to be converted to bytes
		
		byte[] p1 = mdP1.digest();
		
		
		// Every password is converted to Base64
		
		String base64Password1 = Base64.getEncoder().encodeToString(p1);
		
		
		
		if(base64Password1.equals(u1.getPassword()) || base64Password1.equals(u2.getPassword()) || base64Password1.equals(u3.getPassword())) {
			
			
			
			
			try {			
				
					
				do {

				
				// String originalMessage = "With great power comes great responsibility";
				System.out.println("Enter an option: ");
				System.out.println("0. to exit the program: ");
				System.out.println("1. Encrypt a message: ");
				System.out.println("2. Decrypt a message: ");
				
				option = sc.nextInt();
				sc.nextLine();
				
				
				switch(option) {
				
				
				
				case 1:	
					
					// Obtain the key generator
					
					generator = KeyGenerator.getInstance("AES");
					
					// The symmetric key will be generated
					
					sk = generator.generateKey();			
					
					// This object allows to encrypt or decrypt using a key
					
					Cipher cpr = Cipher.getInstance("AES");			
					
					// Now it will be configured the encryptor to use the symmetric key	
					
					cpr.init(Cipher.ENCRYPT_MODE, sk);	
					
					System.out.println("Enter the message to encrypt: ");
					
					originalMessage = sc.nextLine();
					
					// The encryptor works with bytes, it will be converted	
					
					byte[] bytesOriginalMessage = originalMessage.getBytes();		
					
					
					// The encryptor returns a string of bytes
					
					bytesEncryptedMessage = cpr.doFinal(bytesOriginalMessage);
					
					String encryptedMessage = new String(bytesEncryptedMessage);
					
					System.out.println("\nEncrypted Message: " + encryptedMessage + "\n");
					
					break;
					
				case 2:				
										
					//A decryptor will now be configured to use the symmetric key to decrypt. 
					// The SAME key must be used to decrypt, you CANNOT generate or use a different one.
					
					Cipher decoder = Cipher.getInstance("AES");
					
					decoder.init(Cipher.DECRYPT_MODE, sk);
					
					byte[] bytesDecryptedMessage = decoder.doFinal(bytesEncryptedMessage);
					
					System.out.println("\nDecrypted Message: " + new String(bytesDecryptedMessage) + "\n");
					
					
					break;	
					
					
				case 0:				
					
					System.out.println("Bye bye...");
					
					
					break;		
					
								
					default: 
						
						System.out.println("wrong option");
				
				}	
					
		} while(option!=0);
			
			counter = 3;						
			
			sc.close();	
				
			
				
				
				//Exceptions are simplified by catching GeneralSecurityException
			} catch (GeneralSecurityException gse) {
				
				System.out.println("Something has gone wrong..." + gse.getMessage());
				
				gse.printStackTrace();	
			
			}		
		
		
		
			
		
		
		}else {
			
			System.out.println("Incorrect Password: ");
			
			counter ++;
			
		}
		
		}else {
			
			System.out.println("\nIncorrect Name: \n");
			
			counter ++;			
			
		}
		
		}while(counter < 3);		
		
		
		System.out.println("Programm over");		
		
		sc.close();	
		


}
	
	
	
	
}

