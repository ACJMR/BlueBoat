# BlueBoat
## Colin Hosking, Clara Mohri, Shruthi Venkata
### APCS Pd08


# Decisions + runtime  
We decided to order the queue with highest priority at the highest-index side of the ArrayList. 
- `void add(String x)`
  
   This way, adding an element in would be linear time--you would figure out where to insert it element using a binary search, insert it, and move everything to its right side over one. The binary search for where to insert the element costs O(logn) running time, but adding an element in an ArrayList costs O(n) because items must be shifted over.  Therefore, adding an element results in O(n) running time. 

- `String removeMin()`
  
   Removing an element from the queue is constant, O(1), because you take the highest priority element off the right side of the ArrayList, while nothing else changes position.

- `String peekMin()`

  peekMin() also has constant running time, because the get method in ArrayList runs in constant time, and all peekMin() does is employ the get method. peekMin() returns the rightmost element in the ArrayList container.

- `int size`

  We decided on having a size attribute for the APQ. The size attribute makes it easier to implement removeMin() and peekMin(), because we then know that the rightmost element in ArrayList has an index of size - 1. removeMin() decrements size by 1 if the APQ is not empty, and add(String x) increments size by 1.


# heap todo

1. Write constructor method
2. Write `isEmpty()` method
3. Write `add(Integer)` method
4. Write `toString()` method
5. Write `peekMin()` method
6. Write `minChildPos(int)` method
7. Write `removeMin()` method

# Algorithms: 
Add:
1. Add to the end of the heap
2. If the parent is  <= than the added value, then keep in place
3. Else, swap the parent and the added value
4. Keep doing this until the parent of the added value is <= the added value

RemoveMin: 
1. If ALHeap is empty, then return null
2. Else, swap the root / item in first position (min) with the item in the last position. Now remove minimum value, which is in the rightmost position of heap
3. Keep on swapping the value that replaced the minimum value at the root with it's minimum value child until it no longer has children or one child that is larger
