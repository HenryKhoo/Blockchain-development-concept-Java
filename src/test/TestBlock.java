package test;

import blockchain_car.Block;
import blockchain_car.CarRecord;

public class TestBlock {
	public static void main(String[] args) {

		//very-first block
		Block genesis = new Block( "0" );
		//view the genesis block hash
		System.out.println( genesis );
		
		followingBlocks( genesis );
		
	}

	static void followingBlocks( Block genesis ) {
		
		//appended block
		String car1 = "proton|2018|credit|10000.0";
		CarRecord transaction1 = new CarRecord();	
		transaction1.add( car1 );
		Block b1 = new Block( genesis.getHeader().getCurrentHash() );
		b1.setCarRec( transaction1 );
		//view the block hash of b1
		System.out.println( b1 );
		
		//appended block
		String car2 = "proton|2019|credit|10000.0";
		String car3 = "proton|2020|credit|10000.0";
		String car4 = "proton|2021|credit|10000.0";
		CarRecord transaction2 = new CarRecord();	
		transaction2.add( car2 );
		transaction2.add( car3 );
		transaction2.add( car4 );
		Block b2 = new Block( b1.getHeader().getCurrentHash() );
		b2.setCarRec( transaction2 );
		//view the block hash of b2
		System.out.println( b2 );
		
	}
}
