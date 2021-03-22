package org.example;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static int reverseBits(int n) {
//        int ans = 0;
//        for (int i = 0; i < 32; i++) {
//            ans <<= 1;
//            ans = ans | (n & 1);
//            n >>= 1;
//        }
//        return ans;
//    }

    public static void main( String[] args )
    {
        StringBuilder sb = new StringBuilder();
        sb.append('a').append('b');
        sb.insert(0, "cc");
        System.out.println(sb.toString());
//        List<List<Character>> mapping = new ArrayList<List<Character>>(){
//            {
//                add(new ArrayList<Character>() {
//                    {
//                        add('I');
//                        add('V');
//                        add('X');
//                    }
//                });
//                add(new ArrayList<Character>() {
//                    {
//                        add('X');
//                        add('L');
//                        add('C');
//                    }
//                });
//                add(new ArrayList<Character>() {
//                    {
//                        add('C');
//                        add('D');
//                        add('M');
//                    }
//                });
//                add(new ArrayList<Character>() {
//                    {
//                        add('M');
//                    }
//                });
//            }
//        };
//
//        mapping.forEach(list -> {
//            list.forEach(c -> {
//                System.out.println(c);
//            });
//            System.out.println();
//        });

//        String s = "0034";
//        System.out.println(Integer.parseInt(s));
//        char a = 'A';
//        System.out.println(a - '0');
//        String str = "1";
//        System.out.println(str.substring(0,1));

//        int max_exp = (int) (Math.log(Integer.MAX_VALUE) / Math.log(3));
////        int ans = (int) res;
//        int max_val = (int) Math.pow(3,max_exp);
//        System.out.println(max_val);
//        System.out.println(reverseBits(3));


//        int[] x = new int[] { 1, 2, 3, 4, 5 };
//        int[] y = new int[] { 2, 4, 6, 8, 10 };
//        Point[] points = new Point[x.length];
//
//        for (int i = 0; i < x.length; i++) {
//            points[i] = new Point(x[i], y[i]);
//        }
//
//        Arrays.sort(points, (a, b) -> b.x - a.x);
//
//        System.out.println( points[0] );

//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);
//        queue.poll();

//        double a = 2 * Math.pow(10,8);
//        System.out.println(a);
//
//        int b = 10000;
//        if (b > a)
//            System.out.println("b is more than a.");
//        else
//            System.out.println("a is more than b.");
//        char c = 'x';
//        System.out.println(Character.isDigit(c));

//        TreeMap<String, List<String>> map = new TreeMap<>();
//        map.put("id3", new ArrayList<>(Arrays.asList("string1")));
//        List<String> val = map.getOrDefault("id3", new ArrayList<>());
//        val.add("string2");
//        map.put("id3", val);
//
//        List<String> val2 = map.getOrDefault("id2", new ArrayList<>());
//        val2.add("string3");
//        map.put("id2", map.getOrDefault("id2", val2));
//        List<String> sList = new ArrayList<>();
//        sList.add("abc");
//        sList.add("bbc");
//        sList.add("bba");
//        Collections.sort(sList);

//        String test = "I am a good man";
//        test.split(" ", 2);


//        int[] nums = {4, 1, 2,1 ,2};
//        System.out.println(singleNumber(nums));

    }

//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        List<Integer> list = new ArrayList<>();
//        int i = 0, j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] == nums2[j]) {
//                list.add(nums1[i]);
//                i++;
//                j++;
//            } else if (nums1[i] > nums2[j]) {
//                j++;
//            } else {
//                i++;
//            }
//        }
//
//        return list.toArray(new Integer[0]);
//    }

//    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i : nums) {
//            System.out.println(i);
//        }
//        Stack<Integer> stack = new Stack<>();
//        stack.push(nums[0]);
//
//        int i = 1;
//        for (; i < nums.length; i++) {
//            if (stack.isEmpty()) {
//                stack.push(nums[i]);
//            } else {
//                if (nums[i] == stack.peek()) {
//                    stack.pop();
//                } else {
//                    return nums[i - 1];
//                }
//            }
//        }
//
//        return nums[i - 1];
//    }

//    public boolean isHappy(int n) {
//        Set<Integer> set = new HashSet<>();
//        while (!set.contains(n)) {
//            n = sos(n);
//            if (n == 1) {
//                return true;
//            }
//
//            set.add(n);
//        }
//
//        return false;
//    }
//
//    public int sos(int x) {
//        int quadraticSum = 0;
//        while (x / 10 > 0) {
//            quadraticSum += (x % 10) * (x % 10);
//            x /= 10;
//        }
//        quadraticSum += x * x;
//        return quadraticSum;
//    }
}
