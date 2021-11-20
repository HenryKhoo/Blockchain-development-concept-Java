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
		String car1 = "proton saga|20/11/2021|30/11/2021|credit|60";
		CarRecord transaction1 = new CarRecord();	
		transaction1.add( car1 );
		Block b1 = new Block( genesis.getHeader().getCurrentHash() );
		b1.setCarRec( transaction1 );
		//view the block hash of b1
		System.out.println( b1 );
		
		//appended block
		String car2 = "perdua myvi|20/11/2021|30/11/2021|credit|50";
		String car3 = "toyota hilux|20/11/2021|27/11/2021|credit|150";
		String car4 = "Mercedes B|20/11/2021|25/11/2021|credit|200";
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
