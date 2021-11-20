package cryptography;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class DigitalSig {
	private Signature signature;
	
	private final String CRYPTO_ALGORITHM = "RSA";
	
	//Start DEMO
		private KeyPairGenerator keygen;
		private KeyPair keyPair;
		{
			try {
				keygen = KeyPairGenerator.getInstance(CRYPTO_ALGORITHM);
				keyPair = keygen.generateKeyPair();
			} catch (Exception e) {
				
			}
			
		}
	//END DEMO
		
	public DigitalSig() {
		try {
			signature = Signature.getInstance("SHA256WithRSA");
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * sign()
	 */
	public String sign(String data) {
		try {
			signature.initSign(keyPair.getPrivate());
			signature.update(data.getBytes());
			return Base64.getEncoder().encodeToString(signature.sign());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * verify()
	 */
	
	 public boolean verify(String data, String signatureString) {
		 try {signature.initVerify(keyPair.getPublic());
		 signature.update(data.getBytes());
		 return signature.verify(Base64.getDecoder().decode(signatureString));
		 }
		 catch(Exception e) {e.printStackTrace(); return false;}
	 }
}
