/*
Clara Mohri
APCS2 Pd08
HW #46: Arrr, There Be Priorities Here Matey
2018-05-10
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

    //instance vars
    private int size;
    private ArrayList<String> pqueue;

    //constructor
    public ArrayPriorityQueue(){
	size = 0;
	pqueue = new ArrayList<String>();
    }

    //methods:

    //Adds a String to this priority queue. 
    //Uses binary search to identify where the String should be inserted
    //O(n) : The method uses binary search to locate the insertion index which is O(logn), but adding to an ArrayList has a running time of O(n). O(logn + n) -> O(n)
    public void add (String x){
	if (isEmpty())
	    pqueue.add(x);
	
	else {
	    int min = 0;
	    int max = size - 1;
	    int mid = (min + max) / 2;
	    while (min  <  max){
		mid = (min + max) / 2;
		String midStr = pqueue.get(mid);
		int comp = x.compareTo(midStr);
		if (comp == 0){
		    //pqueue.add(mid, x);
		    break;
		}
		else if (comp > 0)
		    min = mid + 1;
		else max= mid - 1;
		//mid = (min + max) / 2;
	    }
	    pqueue.add(mid, x);
	}
	size += 1;
    }//end add(String x)

    //Returns true if this stack is empty, otherwise returns false.
    //O(1) : checks size attribute
    public boolean isEmpty(){
	return (size <= 0);
    }//end isEmpty()

    //Returns the smallest item stored in this priority queue without removing it. 
    //O(n) : the get method of ArrayList runs in O(n) time
    public String peekMin(){
	if (isEmpty())
	    throw new RuntimeException();
	else return pqueue.get(size-1);
    }//end peekMin()

    //Removes and returns the smallest item stored in this priority queue. 
    //O(n) : peekMin() is used and runs in O(n) time
    public String removeMin(){
	if (isEmpty())
	    throw new RuntimeException();
	else {
	    String retStr = peekMin();
	    pqueue.remove(size-1);
	    size -= 1;
	    return retStr;
	}
    }//end removeMin()

    public static void main (String[] args){
	ArrayPriorityQueue a = new ArrayPriorityQueue();
	
	System.out.println("Adding a…");
	a.add("a");
	System.out.println(a.pqueue);
	System.out.println("Adding b…");
	a.add("b");
	System.out.println(a.pqueue);
	System.out.println("Adding C…");
	a.add("C");
	System.out.println(a.pqueue);
	System.out.println("Adding D…");
	a.add("D");
        System.out.println(a.pqueue);
	System.out.println("Adding hello…");
	a.add("hello");
	System.out.println(a.pqueue);

	System.out.println("Removing min…");
	a.removeMin();
	System.out.println(a.pqueue);
	System.out.println("Peek min…");
	System.out.println(a.peekMin());

    }
}
