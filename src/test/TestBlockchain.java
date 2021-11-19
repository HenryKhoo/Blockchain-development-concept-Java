package test;

import blockchain_car.Block;
import blockchain_car.Blockchaincar;
import blockchain_car.CarRecord;

public class TestBlockchain {

	public static void main(String[] args) {
		
		configure();
		
		tstBlockchain2( new String[] { "ali", "peter", "mick", "johnny" }  );

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
	
	/**
	 * configure the system with a genesis block
	 */
	static void configure() {
		Block genesis = new Block( "0" );
		Blockchaincar.nextBlock(genesis);
	}
	
}