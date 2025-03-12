**Assignment 9, Impliment Merge sort and compare to Bubble sort**
In this application there are several functions, mergeSort() recursively divides the randomly generated array into smaller arrays until it has 1 element.
The mergeSort() also calls the merge() function.
In merge(), it takes all the smaller separated arrays and as it compares the elements it will merges them back into orignal array.
There is also a function bubbleSort() that will also sort the array in order of increasing value.
The testSort() function creates a randomly generated array of size 100 (ranging in values from 0-100).
It also will save this array as arrForBubble and arrForMerge.
Then it calls the bubbleSort method for the arrForBubble and the mergeSort method for arrForMerge as well as calculates the computation time in ns for each.
This method also will print that each array is sorted and the time it took so the user can compare.
Finally the main method will call and run the testSort function.
