package org.example.sorting;

// Code from geeksforgeeks website

/*
Merge Sort is a Divide and Conquer algorithm.
It divides input array in two halves, calls itself for the two halves
and then merges the two sorted halves.
The merge() function is used for merging two halves.
The merge(arr, l, m, r) is key process that assumes that arr[l..m]
and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 */

public class MergeSort {
    /*
    Merges two sub-arrays of arr[].
    First sub-array is arr[l...m]
    Second sub-array is arr[m+1...r]
     */
    void merge(int[] arr, int l, int m, int r) {
        // find sizes of two arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l + 0, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

//        for (int i = 0; i < n1; i++) {
//            L[i] = arr[l + i];
//        }
//
//        for (int i = 0; i < n2; i++) {
//            R[i] = arr[m + 1 + i];
//        }

        /* merge temp arrays */
        // initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // initial index of merged sub-array
        int k = l;
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

        // copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }

        // copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    /*
    Main function that sorts arr[l...r] using merge()
     */
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            // find the middle point
            int m = (l + r) / 2;

            // sort first and second half
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /*
    A utility function to print array items
     */
    static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
