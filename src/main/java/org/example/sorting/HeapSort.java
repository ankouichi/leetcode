package org.example.sorting;/**
 * @author: ankouichi
 * @date: 5/3/21 2:08 AM
 * @description:
 */

/**
 * Created by ankouichi on 5/3/21
 */

public class HeapSort {

    /**
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int n = arr.length;
        // build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

//        printArray(arr);

        // one by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i , 0);
        }
    }

    /**
     * heapify a subtree rooted with node i which is
     * an index in arr[]. n is the size of heap
     * @param arr
     * @param n
     * @param i
     */
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
//            printArray(arr);
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 3, 10, 22, 15 };
        printArray(arr);
        HeapSort app = new HeapSort();
        app.sort(arr);
        printArray(arr);
    }
}
