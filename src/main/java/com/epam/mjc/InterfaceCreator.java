package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> strings.stream()
                .allMatch(x -> Character.isUpperCase(x.toCharArray()[0]));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            int limit = integers.size() - 1;
            for (int i = 0; i <= limit; i++){
                if (integers.get(i) % 2 == 0){
                    integers.add(integers.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.toCharArray()[0])
                        && s.endsWith(".")
                        && s.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream()
                .collect(Collectors.toMap(k -> k, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> Stream.concat(integers.stream(), integers2.stream())
                .collect(Collectors.toList());
    }
}