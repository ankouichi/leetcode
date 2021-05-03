package org.example.structure.heap;

/**
 * Created by ankouichi on 2/3/21
 */

public class MaxHeap {
    private int[] heap;
    private int size;
    public MaxHeap(int maxSize) {
        this.size = 0;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return pos * 2 + 1;
    }

    private boolean isLeaf(int pos) {
        return (2 * pos > size) && (pos <= size);
    }

    private void swap(int fPos, int sPos) {
        int tmp = heap[fPos];
        heap[fPos] = heap[sPos];
        heap[sPos] = tmp;
    }

    public void maxHeapify(int pos) {
        if (isLeaf(pos)) return;
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            } else {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
        }
    }

    public void insert(int value) {
        heap[++size] = value;
        int cur = size;
        while (heap[cur] > heap[parent(cur)]) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    // extract max means removing the maximum value from the heap
    public int extractMax() {
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
//        maxHeap.insert(19);
//        maxHeap.insert(6);
//        maxHeap.insert(22);
//        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
    }
}
