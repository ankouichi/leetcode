package org.java8.streamdemo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ankouichi on 3/24/21
 *
 * Stream functionality was introduced in Java 8 in the java.util.stream package -
 * which contains class for processing the sequences of elements.
 *
 */

public class StreamDemo {
    public static void main(String[] args) {
        /// 1. Stream Creation
        // Arrays.stream()
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        // Stream.of()
        stream = Stream.of("a", "b", "c");
        // stream() default function is added to Collection interface,
        // which allows any collection create a stream
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("bb");
        stream = list.stream();

        /// 2. Stream Operations: operations on stream do not change the source
        // 1) intermediate operations - return Stream<T>, which allows chaining
        // 2) terminal operations - return a result of defined type
        long size = stream.distinct().count();
//        System.out.println(size);
//        System.out.println(stream.count());
        // 2.1 Iterating: substitutes of for, for-each, while loops
        // It concentrates on the logic, but not the iteration over the sequence of elements
//        for (String s : list) {
//            if (s.contains("aa"))
//                return true;
//        }
        boolean isExist = list.stream().anyMatch(e -> e.contains("aa"));
        // 2.2 Filtering: filter() method allows us to pick a stream of elements that satisfy a predicate
        list.clear();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
        stream = list.stream().filter(e -> e.contains("e"));
        // 2.3 Mapping: map() method converts elements of a Stream by applying a special function to them
        // and to collect these new elements into a Stream
        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        Stream<Path> pathStream = uris.stream().map(Paths::get);
        // flapMap() example
//        List<Detail> details = new ArrayList<>();
//        details.add(new Detail());
//        Stream<String> stream = details.stream().flatMap(detail -> detail.getParts().stream());
        // 2.4 Matching : anyMatch(), allMath(), noneMatch(), the names are all self-explanatory
        boolean anyExist = list.stream().anyMatch(e -> e.contains("a"));
        boolean allExist = list.stream().allMatch(e -> e.contains("a"));
        boolean noneExist = list.stream().noneMatch(e -> e.contains("a"));

        System.out.println(Stream.empty().allMatch(Objects::nonNull));
        System.out.println(Stream.empty().anyMatch(Objects::nonNull));
        // 2.5 Reduction
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, Integer::sum);
        // 2.6 Collecting
        List<String> resultList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
