/*
  Blue Boat
  Colin Hosking, Clara Mohri, Shruthi Venkata
  APCS2 Pd08
*/

/********************************************
 * class RunMed
 * Implements an efficient running median algorithm.
 ********************************************/

import java.lang.Math;

public class RunMed{

    //instance vars:
    ALHeapMin bigVals;
    ALHeapMax lilVals;

    /**************************************
     * default constructor --- inits instance vars
     ************************************/
    public RunMed(){
	bigVals = new ALHeapMin();
	lilVals = new ALHeapMax();
    }

    /**************************************
     * double getMedian()
     * Returns median
     * Throws error if there is no median (no vals given)
     *************************************/
    public double getMedian(){
	double med;
	int BVL = bigVals.getSize();
	int LVL = lilVals.getSize();
	double BVR = bigVals.peekMin();
	double LVR = lilVals.peekMax();
	if (BVL == LVL)
	    med = ( (BVR + LVR) / 2);
	else if (BVL > LVL) 
	    med = BVR;
	else 
	    med = LVR;
	return med; 	    
    }

    /*************************************
     * void add(Integer)
     * adds newVal to appropriate heap
     * balances if necessary
     **************************************/
    public void add(Integer x){
	//determine where to add:
	if ( lilVals.getSize() > 1 && x < lilVals.peekMax() ) 
	    lilVals.add(x);
	else bigVals.add(x);
	//balance heaps: 
	while( lilVals.getSize() - bigVals.getSize() > 1){
	    bigVals.add(lilVals.removeMax());
	}
	while (bigVals.getSize() - lilVals.getSize() > 1){
	    lilVals.add(bigVals.removeMin());
	}       
    }

    public static void main (String[] args){
	RunMed a = new RunMed();
	a.add(3);
	a.add(5);
	a.add(6);
	System.out.println(a.lilVals);
	System.out.println(a.bigVals);
	System.out.println(a.getMedian());
	for (int i = 0; i < 10; i++){
	    int r = (int) (Math.random() * 10) ;
	    a.add(r);
	}
	System.out.println(a.lilVals);
        System.out.println(a.bigVals);
	System.out.println(a.getMedian());
    }

}

    