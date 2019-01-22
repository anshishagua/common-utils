package com.anshishagua;

import javax.validation.constraints.NotNull;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    @NotNull(message = "werwerwer")
    private Integer a;

    public static void main(String [] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);

        stream.map(it -> it + 3).filter(Predicate.isEqual(5)).forEach(System.out::println);

        Main a = new Main();
        System.out.println(a.a);
    }
}
