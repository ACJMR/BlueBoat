/*
  Blue Boat
  Colin Hosking, Clara Mohri, Shruthi Venkata
  APCS2 Pd08
  HW50 -- Run Run Run
  2018-05-18
*/

/********************************************
 * class RunMed
 * Implements an efficient running median algorithm.
Add
1. If item is less than root of lilVals, add it to lilVals. 
   Else: add it to bigVals
2. Balance lilVals and bigVals:
   While lilVals size - bigVals size exceeds 1 ---> remove the root of lilVals and add it to bigVals
   While bigVals size - lilVals size exceeds 1 ---> remove the root of bigVals and add it to lilVals

getMedian
1. If the size of lilVal and bigVal are equal, return the average of their roots
2. If bigVal is larger than lilVal, return the root of bigVal.
3. Else: return the root of lilVal
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
	if (BVL == LVL) //If the size of lilVal and bigVal are equal, return the average of their roots
	    med = ( (BVR + LVR) / 2);
	else if (BVL > LVL) // If bigVal is larger than lilVal, return the root of bigVal.
	    med = BVR;
	else 
	    med = LVR; //Else: return the root of lilVal
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

    
