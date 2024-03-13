package data_structure;

import java.util.*;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        // ways to create a stream
        Stream<Map.Entry<Object, Object>> collectionStream = map.entrySet().stream();
        Stream<Map.Entry<Object, Object>> parallelCollectionStream = map.entrySet().parallelStream();
        Stream<Object> arrayStream = Arrays.stream(new Object[10]);
        Stream.of(0, 1, 2).forEach(System.out::println);
        Stream.iterate(0, o -> o + 1).limit(3).forEach(System.out::println);
        Stream.iterate(0, o -> o < 3, o -> o + 1).forEach(System.out::println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);



    }
}
