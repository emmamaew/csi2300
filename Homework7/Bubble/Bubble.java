import java.util.*;
import java.io.*;

public class Bubble {
    // Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n-1; i++){
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    //this will swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            //quit if swap is not necessary
            if (!swapped) {
                break;
            }
        }
    }


// Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {
        int[] arr = new int[arrayLength];
        Random randGen = new Random();

        for (int i = 0; i < arrayLength; i++) {
            arr[i] = randGen.nextInt(101);
        }
        return arr;
    }

 
// Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int num : array) {
                //make number into string
                writer.write(Integer.toString(num));
                writer.newLine();
            }

            System.out.println("Array has been written to " + filename);

        } catch (IOException e) {
            //displays error
            System.out.println("Error writing array to file: " + e.getMessage());
        }
    }

// This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Error occured reading from file: " + e.getMessage());
            return null;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }


// The main function will handle a user's keyboard input specified in the next session
    public static void main(String[] args) {
       int arrayLength = 10; //just an test array length
       int[] randomArray = createRandomArray(arrayLength);
       
       System.out.println("Random Array Before Bubble Sort:");
       for (int num : randomArray) {
            System.out.print(num + " ");
       }

       //line to organize results better
       System.out.println();  
       System.out.println();

       //sorting the array
       bubbleSort(randomArray); 

       String filename = "Array.txt";
       writeArrayToFile(randomArray, filename);

        //line to organize results better
        System.out.println();  

       int[] readArray = readFileToArray(filename);

       if(readArray != null) {
            System.out.println("Here is the sorted array read from file:");
            for (int num: readArray) {
                System.out.print(num + " ");
            }
       } else {
            System.out.println("Could not read file");
       }
    }
}