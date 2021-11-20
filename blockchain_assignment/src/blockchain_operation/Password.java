package blockchain_operation;


import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Hex;

import blockchain_operation.Hashed;
import blockchain_operation.IO;

public class Password {
	public static String ID;
    private static final String ALGO = "SHA-256";
    public static final Logger logger = null;
    private static final String FILE = "secret.txt";
    private static final String FILE_LOGIN = "login.txt";
    private static final String uuid;
    
    static {
        uuid = UUID.randomUUID().toString();
    }
    
    public static boolean compare(String id, String pw) {
    	boolean flag = false;
    	int count = 0;
    	//ID = id;
    	List<String> loginCheck = IO.read(FILE_LOGIN);
        List<String> secretCheck = IO.read(FILE);
        String foundID;
        String foundUUID = null;

        for (int i = 0; i < loginCheck.size(); i++) {
        	String[] splitLogin = loginCheck.get(i).split("\\|"); //split by character "|", usage of \\ because | is a control char
        	String checkID = splitLogin[0];
            if (checkID.equals(id)) {
                foundUUID = splitLogin[1];
            }
        }
        
        for(int i = 0; i < secretCheck.size(); i++) {
        	String[] splitSecret = secretCheck.get(i).split("\\|");
        	String checkUUID = splitSecret[0];
        	if(checkUUID.equals(foundUUID)) {
        		String salt = splitSecret[1];
        		String hash = splitSecret[2];
        		String hashPW = Hashed.hash(pw, salt, ALGO);
        		if(hashPW.equals(hash)) {
        			flag = true;
        			return flag;
        		}
        	}
        }
        
    	return flag;
    }
    
    public static void create(String id, String pw) {
    	try {
    		String salt = Hex.encodeHexString(Hashed.getSecureRand(16));
			String hash = Hashed.hash(pw, salt, ALGO);
			
			IO.write(FILE, String.join("|", uuid, salt, hash));
			IO.write(FILE_LOGIN, String.join("|", id, uuid));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.toString());
		}
    }
}
