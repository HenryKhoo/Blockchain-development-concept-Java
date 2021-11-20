package blockchain_car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarRecord implements Serializable {
private final int SIZE = 16;
	
	//array or collection
	//String[] tranxLst;
	List<String> carLst; //simple demo...
	
	public CarRecord() {
		carLst = new ArrayList<>( SIZE );
	}
	
	//add( String ) : void
	public void add( String tranx ){
		carLst.add(tranx);
	}

	@Override
	public String toString() {
		return "Cars [carLst=" + carLst + "]";
	}
}
