import java.util.Arrays;

public class generics {

    //generic mergeSort
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length < 2) {
            return;
        }

        int m = (arr.length) / 2;
        T[] L = Arrays.copyOfRange(arr, 0, m);
        T[] R = Arrays.copyOfRange(arr, m, arr.length);
        
        mergeSort(L);
        mergeSort(R);

        merge(arr, L, R);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, T[] L, T[] R) {

        int i=0, j=0, k=0;
        while ( i < L.length && j < R.length) {
            if(L[i].compareTo(R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < L.length) {
            arr[k++] = L[i++];
        }
        while (j < R.length) {
            arr[k++] = R[j++];
        }
    }

    //generic bubble sort
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++){
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    //this will swap arr[j+1] and arr[j]
                    T temp = arr[j];
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

    //generic method to show if array is sorted or not
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //generic method to print the array
    public static <T> void printArray(T[] arr) {
        for(T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }    

    public static void main(String[] args) {
        //run merge
        Integer[] mergeArr = {2, 7, 6, 3, 8, 9, 1, 4, 15, 27, 36, 5, 16, 21, 22, 34, 11, 29, 30};
        System.out.println("Initial array: ");
        printArray(mergeArr);

        long startMerge = System.nanoTime();
        mergeSort(mergeArr);
        long elapsedMerge = System.nanoTime() - startMerge;

        System.out.println("Array is sorted: " + isSorted(mergeArr));

        System.out.println("MergeSort time (ns): " + elapsedMerge);
        System.out.println("Sorted array: ");
        printArray(mergeArr);

        //run bubble
        Integer[] bubbleArr = {2, 7, 6, 3, 8, 9, 1, 4, 15, 27, 36, 5, 16, 21, 22, 34, 11, 29, 30};
        System.out.println("Initial array: ");
        printArray(bubbleArr);

        long startBubble = System.nanoTime();
        bubbleSort(bubbleArr);
        long elapsedBubble = System.nanoTime() - startBubble;

        System.out.println("Array is sorted: " + isSorted(bubbleArr));

        System.out.println("BubbleSort time (ns): " + elapsedBubble);
        System.out.println("Sorted array: ");
        printArray(bubbleArr);
    }

} 
