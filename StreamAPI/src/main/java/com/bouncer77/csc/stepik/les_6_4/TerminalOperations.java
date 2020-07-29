package com.bouncer77.csc.stepik.les_6_4;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {

        // Терминальную операцию на стриме можно выполнить лишь один раз,
        // после чего этот объект стрима больше не пригоден к использованию

        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::print);

        IntStream stream;

        stream = IntStream.iterate(1, n -> n + 1);
        OptionalInt firstEl = stream.findFirst();


        stream = IntStream.iterate(1, n -> n + 2);
        OptionalInt anyEl = stream.findAny();

        System.out.println("\nfirts: " + firstEl
                + " ; any: " + anyEl
                );

        stream = IntStream.iterate(100, n -> n + 2);
        boolean conditionLess10 = stream.allMatch(s -> s > 10);
        System.out.println(conditionLess10);

        stream = IntStream.iterate(1, n -> n + 2);
        boolean conditionLess11 = stream.allMatch(s -> s < 11);
        System.out.println(conditionLess11);


        stream = IntStream.range(100, 200);
        boolean conditionLess12 = stream.allMatch(s -> s > 12); // все элементы
        System.out.println(conditionLess12);

        stream = IntStream.range(100, 200);
        System.out.println(stream.anyMatch(s -> s > 150)); // хотя бы один

        stream = IntStream.range(100, 200);
        System.out.println(stream.noneMatch(s -> s > 150)); // хотя бы один

        stream = IntStream.range(100, 200);
        OptionalInt optionalInt1 = stream.min();
        System.out.println("минимальный эдимент: " + optionalInt1);

        stream = IntStream.range(100, 200);
        OptionalInt optionalInt2 = stream.max();
        System.out.println("максимальный эдимент: " + optionalInt2);

        List<String> stringList = List.of("el4444", "el1", "el22", "el333");
        Optional<String> optionalS = stringList.stream()
                .min(Comparator.comparing(
                        String::length, Integer::compare));
        stringList.forEach(System.out::println);
        System.out.println("min length optionalString: " + optionalS);

        IntStream stream1 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        long count = stream1.count();
        System.out.println(count);

        stream1 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        long sum = stream1.sum();
        System.out.println(sum);

        // Преобразовать Stream в коллекцию (Collection)
        Stream<String> stream2 = Stream.of("line1", "line5", "line6", "line3");
        List<String> strList = stream2.collect(Collectors.toList()); // Collector
        System.out.println(strList);

        Stream<BigInteger> bigIntegerStream = Stream.of(
                BigInteger.valueOf(10),
                BigInteger.valueOf(30),
                BigInteger.valueOf(20),
                BigInteger.valueOf(70)
        );
        // Если стрим пуст, то возвращается нулевое значение
        BigInteger bigSum = bigIntegerStream.reduce(BigInteger.ZERO, BigInteger::add); // reduce - свертка
        // Применение бинарного оператора последовательно ко всем элементам стрима пока в стриме не останется один элемент
        System.out.println("bigSum = " + bigSum);

    }
}
