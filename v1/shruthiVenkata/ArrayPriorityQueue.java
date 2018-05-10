/*
  Joan Chirinos, Shruthi Venkata
  HW46 -- Arrr, There Be Priorities Here Matey
  APCS2 pd8
  2018-05-18
*/

import java.util.ArrayList;
import java.lang.RuntimeException;

public class ArrayPriorityQueue implements PriorityQueue {

  ArrayList<String> _data;

  public ArrayPriorityQueue() {
    _data = new ArrayList<String>();
  }


  //sorts queue based on priority upon adding, sort of like insertion sort
  //O(n)
  public void add(String toAdd) {

    //if no elements, or least priority element is higher than toAdd, add to end
    if (size() == 0 || _data.get(size() - 1).compareTo(toAdd) >= 0) {
      _data.add(toAdd);
      return;
    }

    //else if first element has lower priority than toAdd, add to index 0
    else if (_data.get(0).compareTo(toAdd) < 0) {
      _data.add(0, toAdd);
      return;
    }

    //otherwise traverse AL and put toAdd into right spot
    else {
      for (int pos = size() - 1; pos > 0; pos--) {
        if (_data.get(pos - 1).compareTo(toAdd) > 0) {
          _data.add(pos, toAdd);
          return;
        }
      }
    }
  }

  //O(1)
  public boolean isEmpty() {
    return this.size() == 0;
  }

  //O(1)
  public String peekMin() {
    if (size() == 0) {
      throw new RuntimeException();
    }
    return _data.get(size() - 1);
  }

  //O(1)
  public String removeMin() {
    if (size() == 0) {
      throw new RuntimeException();
    }
    return _data.remove(size() - 1);
  }

  public int size() {
    return _data.size();
  }

  public String toString() {
    return "END: " + _data.toString() + " :FRONT";
  }

  public static void main(String[] args) {
    ArrayPriorityQueue apq = new ArrayPriorityQueue();
    System.out.println("apq: " + apq);
    apq.add("hoo");
    System.out.println("apq: " + apq);
    apq.add("boo");
    System.out.println("apq: " + apq);
    apq.add("doo");
    System.out.println("apq: " + apq);
    System.out.println("removing min: " + apq.peekMin());
    apq.removeMin();
    System.out.println("apq: " + apq);
    apq.add("zoo");
    System.out.println("apq: " + apq);
    apq.add("aoo");
  }

}//end class
