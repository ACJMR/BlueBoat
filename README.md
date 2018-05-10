# BlueBoat

# Decisions + runtime  
We decided to order the queue with highest priority at the highest-index side of the APQ. This way, adding an element in would be linear time--you would figure out where to insert it element using a binary search, insert it, and move everything to its right side over one, resulting in a method that takes log n + n time, and is O(n). Removing an element from the queue would be constant, O(1), because you take the highest priority one off the right side, while nothing else changes position.
