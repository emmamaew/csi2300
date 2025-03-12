
public class Merge {

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        //temp. arrays for left and right pieces
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        //merging the sorted pieces back to array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

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

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
        

    public static void testSort() {
        int size = 100; 
        int[] arrForBubble = new int[size];
        int[] arrForMerge = new int[size];
        java.util.Random rand = new java.util.Random();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(101);
            arrForBubble[i] = num;
            arrForMerge[i] = num;
        }

        long startBubble = System.nanoTime();
        bubbleSort(arrForBubble);
        long elapsedBubble = System.nanoTime() - startBubble;

        //testing mergeSort
        long startMerge = System.nanoTime();
        mergeSort(arrForMerge, 0, arrForMerge.length -1);
        long elapsedMerge = System.nanoTime() - startMerge;

        System.out.println("MergeSort sorted: " + isSorted(arrForMerge));
        System.out.println("MergeSort time (ns): " + elapsedMerge);
        System.out.println("BubbleSort sorted: " + isSorted(arrForBubble));
        System.out.println("BubbleSort time (ns): " + elapsedBubble);
    }

    public static void main(String[] args) {
        testSort();
    }
    
    
}
