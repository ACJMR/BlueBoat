# BlueBoat

# Decisions + runtime  
We decided to order the queue with highest priority at the highest-index side of the ArrayList. 
- add(String x)
  
   This way, adding an element in would be linear time--you would figure out where to insert it element using a binary search, insert it, and move everything to its right side over one. The binary search for where to insert the element costs O(logn) running time, but adding an element in an ArrayList costs O(n) because items must be shifted over.  Therefore, adding an element results in O(n) running time. 

- removeMin()
  
   Removing an element from the queue is constant, O(1), because you take the highest priority element off the right side of the ArrayList, while nothing else changes position.

- peekMin()

  peekMin() also has constant running time, because the get method in ArrayList runs in constant time, and all peekMin() does is employ the get method. peekMin() returns the rightmost element in the ArrayList container.

- int size

  We decided on having a size attribute for the APQ. The size attribute makes it easier to implement removeMin() and peekMin(), because we then know that the rightmost element in ArrayList has an index of size - 1. removeMin() decrements size by 1 if the APQ is not empty, and add(String x) increments size by 1.
