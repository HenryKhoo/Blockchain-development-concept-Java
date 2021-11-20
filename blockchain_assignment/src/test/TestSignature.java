package test;

import cryptography.DigitalSig;

public class TestSignature {
	public static void main (String[] args) {
		String data = "demo";
		tst2(data);

	}
	static void tst2(String data) {
		DigitalSig bds = new DigitalSig();
		System.out.println("Data:"+data);
		
		String signature = bds.sign(data);
		System.out.println("Signature:"+signature);
		
		System.out.println();
		boolean isValid = bds.verify(data, signature);
		System.out.println((isValid)? "Correct data!" :"Incorrect data!");
		
	}
}
