package blockchain_car;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class BlockchainHasher {
	//hash(String, String) : String
	public static String hash( byte[] blockBytes, String algorithm ) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);	
			byte[] hashBytes = md.digest( blockBytes );
			hash = String.valueOf( Hex.encodeHex(hashBytes) );			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hash;
	}
}
