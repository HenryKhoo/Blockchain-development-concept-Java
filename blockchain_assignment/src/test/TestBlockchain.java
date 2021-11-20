package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import blockchain_car.Block;
import blockchain_car.Blockchaincar;
import blockchain_car.CarRecord;


public class TestBlockchain {

	public static void main(String[] args) {
		
		configure();
		
		//tstBlockchain2( new String[] { "ali", "peter", "mick", "johnny" }  );
		tstBlockchain3("src/dataset/carData.txt");
	}
	
	/**
	 * code reference for the exercise - dummytranx.txt
	 */
	static void tstBlockchain2( String[] lst ) {
		
		CarRecord c1 = new CarRecord();
		c1.add( lst[0] );
		c1.add( lst[1] );
		CarRecord c2 = new CarRecord();
		c2.add( lst[2] );
		c2.add( lst[3] );
		CarRecord[] tranxCollection = { c1, c2 };
		
		for ( int i = 0; i < tranxCollection.length; i++ ) {
			Block blk = new Block( 
					Blockchaincar.get().getLast().getHeader().getCurrentHash() 
					);
			blk.setCarRec( tranxCollection[i] );
			Blockchaincar.nextBlock( blk );
			
		}
		Blockchaincar.distribute();
		
	}

	static void tstBlockchain( String[] lst ) {
		
		CarRecord c1 = new CarRecord();
		c1.add( lst[0] );
		c1.add( lst[1] );
		c1.add( lst[2] );
		c1.add( lst[3] );
		Block blk = new Block( 
				Blockchaincar.get().getLast().getHeader().getCurrentHash() 
				);
		blk.setCarRec(c1);
		Blockchaincar.nextBlock( blk );
		
		Blockchaincar.distribute();
	}
	static void tstBlockchain3( String filename ) {
		
		ArrayList<String> DB = new ArrayList<>();
		
		try {
			File file = new File(filename);
			Scanner readByLine = new Scanner(file);
			while (readByLine.hasNextLine()) {
				DB.add(readByLine.nextLine());
				
			}
			readByLine.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CarRecord c1 = new CarRecord();
		
		int a= 0;
		for(int i=0; i<DB.size();i++) {
			
			c1.add(DB.get(i));
			
	
			// every 5 transaction and until end of array
			a++;
			if ( i == DB.size()-1 || a == 5) {
			a = 0;
			Block blk = new Block( Blockchaincar.get().getLast().getHeader().getCurrentHash() );
			blk.setCarRec(c1);
			Blockchaincar.nextBlock( blk );
			c1 = new CarRecord();
			
			}
			
		}
		Blockchaincar.distribute();
		
		
	}
	/**
	 * configure the system with a genesis block
	 */
	static void configure() {
		Block genesis = new Block( "0" );
		Blockchaincar.nextBlock(genesis);
	}
	
}