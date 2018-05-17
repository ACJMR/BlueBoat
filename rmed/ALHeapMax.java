/*
  Blue Boat
  Colin Hosking, Clara Mohri, Shruthi Venkata
  APCS2 Pd08
*/

/*****************************************************
 * class ALHeapMax
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMax
{
    
    //instance vars
    private ArrayList<Integer> _heap; 
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax() 
    { 
	_heap = new ArrayList<Integer>();
	_heap.add(null);
    }

    
    
    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns levels of tree
     *****************************************************/
    public String toString() 
    { 
	String retStr = "";
        int pow = 0;
        int num = 0;
        for (Integer i: _heap){
	    retStr += i + " ";
	    num += 1;
	    if (num >= Math.pow(2, pow)){
		retStr += "\n";
		pow += 1;
	    }
	}	
        return retStr;
    }//O(n)
    
    
    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    { 
	return _heap.size() <= 1;
    }//O(1)
    
    
    /*****************************************************
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax()
    { 
	return _heap.get(1);
    }//O(1)
    
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * Procedure for adding: 
     * 1. Add to the end of the _heap
       2. If the parent is  <= than the added value, then keep in place
       3. Else, swap the parent and the added value
       4. Keep doing this until the parent of the added value is <= the added value
     *****************************************************/

    public void add( Integer addVal )
    { 
	_heap.add(addVal);

	int addedIndex = _heap.size() - 1;

	int parentIndex = addedIndex / 2;

	while (parentIndex >= 1 &&  _heap.get(parentIndex) < _heap.get(addedIndex) ){
	    swap(parentIndex, addedIndex);
	    addedIndex = parentIndex;
	    parentIndex = addedIndex / 2;

	}
    }//O(logn)
    
    
    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns greatest element in heap.
     * Postcondition: Tree maintains heap property.
     * Proced re for removing min: 
     * 1. If ALHeap is empty, then return null
       2. Else, swap the root / item in first position (max) with the item in the last position. Now remove maximum value, which is in the rightmost position of _heap
       3. Keep on swapping the value that replaced the maximum value at the root with it's maximum value child until it no longer has children or one child that is larger
     *****************************************************/
    public Integer removeMin()
    {

	if (isEmpty()){
	    return null;
	}
	swap(1, _heap.size()-1);
	int ans = _heap.remove(_heap.size()-1);
	int parent = 1;
	int child = maxChildPos(parent);
	while (child > -1){
	    swap(parent,child);
	    parent = child;
	    child = maxChildPos(parent);
	}
	return ans;
    }//O(logn)
    
    
    /*****************************************************
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of greatest child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     * The children of a parent are located at 2* pos and/or 2*pos + 1, if they exist
     *****************************************************/
    private int maxChildPos( int pos )
    { 
	if (pos >= _heap.size()) return -1;
	if ( (2*pos) >= _heap.size()-1) return -1;
	else {
	    if (_heap.get(2*pos) < _heap.get(2*pos + 1)) return (2*pos + 1);
	    else return 2*pos;
	}

    }//O(1)
    
    
    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }
    
    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************
    
    
    
    //main method for testing
    public static void main( String[] args )
    {

	  ALHeapMax pile = new ALHeapMax();
	  
	  pile.add(2);
	  System.out.println(pile);       
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);

	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	   
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()
    
}//end class ALHeapMax
