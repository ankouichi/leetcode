package org.problems.recursion;

/**
 * @author: Daniel
 * @date: 2021/4/14 16:54
 * @description:
 */
public class LC779_Medium_KthSymbolInGrammar {
    /**
     * Approach: Recursion + Flipped
     * Property 1: The second half of each line is the flipped of the first half, which means 0 -> 1 and 1 -> 0.
     * Property 2: The first half of next line is the same as this line.
     * Time - O(N), Space - O(1)
     * @param N
     * @param K
     * @return
     */
    public static int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K > 1 << (N - 2)) {
            return kthGrammar(N - 1, K - (1 << (N - 2))) ^ 1;
        }
        return kthGrammar(N - 1, K);
    }

    /**
     * Approach: Recursion + Parent Variable
     * The parent of the element at N-th row and K-th index is the element at N-1 row and (K + 1) / 2 index.
     * If parent is 0, then the element should be 1 - K % 2, other wise K % 2;
     * Time - O(N), Space - O(N)
     * @param N
     * @param K
     * @return
     */
    public static int kthGrammar2(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar2(N - 1, (K + 1) / 2);
    }

    /**
     * Approach: Binary Count
     * @param N
     * @param K
     * @return
     */
    public static int kthGrammar3(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2,2));
        System.out.println(kthGrammar(3,3));
        System.out.println(kthGrammar(4,5));
        System.out.println(kthGrammar(4,4));
        System.out.println(kthGrammar(4,3));

        System.out.println();
        System.out.println(kthGrammar2(1,1));
        System.out.println(kthGrammar2(2,2));
        System.out.println(kthGrammar2(3,3));
        System.out.println(kthGrammar2(4,5));
        System.out.println(kthGrammar2(4,4));
        System.out.println(kthGrammar2(4,3));
    }
}
