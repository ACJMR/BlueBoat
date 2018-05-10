//Colin Hosking
//APCS02 pd08
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-10
import java.util.ArrayList;

public class ArrayPriorityQueue<String> implements PriorityQueue<String>{
    private ArrayList<String> _data;

    public ArrayPriorityQueue(){ //O(1) CONSTANT
	_data = new ArrayList<String>();
    }

    //Adds element c
    public void add(String c){ //O(1) CONSTANT
	_data.add(c);
    }
    
    //If PriorityQueue is empty, returns true. Returns false otherwise
    public boolean isEmpty(){  //O(1) CONSTANT
	return _data.size() == 0;
    }
    
    //returns element with most priority
    public String peekMin(){ //O(n) CONSTANT
	if (this.isEmpty()){
	    return null;
	}
	int highestPriority = 0;
	
        for (int i = 0; i < _data.size(); i++){
	    int a = _data.get(highestPriority).toString().compareTo(_data.get(i).toString()); //is current highestPriority greater than element at i? 
	    if (a > 0){
		highestPriority = i;
	    }
	}
	return _data.get(highestPriority);
    }
    
    //returns and removes element with most priority
    public String removeMin(){ //O(n) CONSTANT
	if (this.isEmpty()){
	    return null;
	}
	int highestPriority = 0;
	
	for (int i = 0; i < _data.size(); i++){
	    int a = _data.get(highestPriority).toString().compareTo(_data.get(i).toString()); //is current highestPriority greater than element at i? 
	    if (a > 0){
		highestPriority = i;
	    }
	}
        String ans = _data.get(highestPriority);
	_data.remove(highestPriority);
	return ans;	
    }

    
}
