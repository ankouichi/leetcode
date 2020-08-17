package org.example.sorting;

// Code from geeksforgeeks website

public class BinarySearch {
    /*
        Implementation of recursive Binary Search
        Return index of x if it is present in arr[l...r],
        otherwise return -1
     */
    int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }

    /*
        Implementation of iterative Binary Search
        Return index of x if it is present in arr[l...r],
        otherwise return -1
     */
    int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while ( l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {2,3,4,5,6,20,40,60};
        int x = 20;
//        int idx = bs.binarySearch(arr, 0, arr.length - 1, x);
        int idx = bs.binarySearch(arr, x);
        if (idx == -1)
            System.out.println("element not present");
        else
            System.out.println("element present at index: " + idx);
    }
}
