package blockchain_car;

import java.io.Serializable;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;

//import my.apu.bcd.function.Transaction;
//import my.apu.bcd.function.Block.Header;


public class Block implements Serializable{
	private Header header;
	private CarRecord carRec;
	
	public Block (String previousHash) {
		this.header = new Header();
		this.header.previousHash = previousHash;
		this.header.timeStamp = new Timestamp( System.currentTimeMillis() ).getTime();	
		//for now, hard-coded merkle root
		this.header.setMerkleRoot("6a1f0ff1286e440668aebc80861afecb2161ff2f06f195531e3edb4ec9099c82");
		
		byte[] blockBytes = getBytes( this );
		this.header.currentHash = BlockchainHasher.hash( blockBytes, "SHA-256" );
	}
	public void setCarRec(CarRecord carRec) {
		this.carRec = carRec;
	}
	
	public Header getHeader() {
		return header;
	}
	public class Header implements Serializable{
		private int index;
		private String carID;
		private CarRecord carRecord;
		private String currentHash;
		private String previousHash;
		private long timeStamp;
		private String merkleRoot;
		
		/*
		 * getter and setter 
		 */
		
		public int getIndex() {
			return index;
		}
		public String getCarID() {
			return carID;
		}
		public void setCarID(String carID) {
			this.carID = carID;
		}
		public CarRecord getCarRecord() {
			return carRecord;
		}
		public void setCarRecord(CarRecord carRecord) {
			this.carRecord = carRecord;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getCurrentHash() {
			return currentHash;
		}
		public void setCurrentHash(String currentHash) {
			this.currentHash = currentHash;
		}
		public String getPreviousHash() {
			return previousHash;
		}
		public void setPreviousHash(String previousHash) {
			this.previousHash = previousHash;
		}
		public long getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getMerkleRoot() {
			return merkleRoot;
		}
		public void setMerkleRoot(String merkleRoot) {
			this.merkleRoot = merkleRoot;
		}
		@Override
		public String toString() {
			return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
					+ ", timeStamp=" + timeStamp + "]";
		}
		
	}
	//getBytes( Block ) : byte[]
		private byte[] getBytes( Block block ){
			
			try( ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
				 ObjectOutputStream out = new ObjectOutputStream( baos );	
					) {
				out.writeObject( block );
				return baos.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		public String toString() {
			return "Block [header=" + header + ", carRec=" + carRec + "]";
		}
}
