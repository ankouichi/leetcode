package org.example.sorting;/**
 * @author: ankouichi
 * @date: 5/3/21 2:08 AM
 * @description:
 */

/**
 * Created by ankouichi on 5/3/21
 */

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

    }

    // heapify a subtree rooted with node i which is
    // an index in arr[]. n is the size of heap
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[i])
            largest = l;
        if (r < n && arr[r] > arr[i])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {

    }

    public static void main(String[] args) {

    }
}
