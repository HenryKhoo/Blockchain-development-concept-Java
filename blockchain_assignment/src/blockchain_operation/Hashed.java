package blockchain_operation;
import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class Hashed {
	public static byte[] getSecureRand(int bit)
	{
		SecureRandom sr = new SecureRandom();
		byte[] b = new byte[ bit ];
		sr.nextBytes( b );
		return b;
	}
	
	public static String hash( String data, String algorithm ) 
	{
		String hash = null;
		//MessageDigest
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);	
			md.update( data.getBytes() );

			byte[] hashBytes = md.digest();
			hash = String.valueOf( Hex.encodeHex(hashBytes) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	//overloaded hash( String, String, String ) : String
	public static String hash( String data, String salt, String algorithm ) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);	
			md.update( data.getBytes() );
			md.update( salt.getBytes() ); 
			//digest 
			byte[] hashBytes = md.digest();
			hash = String.valueOf( Hex.encodeHex(hashBytes) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	//put salt value to the hashing
	//salt()
	
	//overloaded hash() for hashing the block object
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
