package com.bouncer77.csc.stepik.les_6_4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Создание стримов возможно:\n" +
                "1. Сгенерировать на месте вызова\n" +
                "2. Получить из String - метод .chars()\n" +
                "3. Из коллекции\n" +
                "4. Из BufferedReader\n" +
                "5. Из директорий\n" +
                "\n" +
                "Способы 4 и 5 выделяют системные ресурсы, следовательно оборачиваются блоком try-catch\n\n");

        // 1 Сгенерировать на месте с помощью Supplier (поставщика)

        System.out.println("1. Сгенерировать на месте вызова\n" +
                "    1.1 с помощью Supplier (поставщика)\n" +
                "    1.2 итерирование кокай-то функции\n" +
                "\t1.3 из диапозона чисел (Пример: от 0 до 99) (не включая конец диапозона)\n" +
                "\t1.4 из диапозона чисел\n (Пример от 0 до 100)(включая конец диапозона)");
        // 1
        DoubleStream randomNumbers = DoubleStream.generate(Math::random).limit(5);

        // 2
        IntStream intStream = IntStream.iterate(0, n -> n + 1).limit(5);

        // 3
        IntStream smallIntegers1 = IntStream.range(0, 100).limit(5);

        // 4
        IntStream smallIntegers2 = IntStream.rangeClosed(0, 100).limit(5);

        System.out.println("    1.1 DoubleStream randomNumbers = DoubleStream.generate(Math::random);\n" +
                "    1.2 IntStream intStream = IntStream.iterate(0, n -> n + 1);\n" +
                "    1.3 IntStream smallIntegers1 = IntStream.range(0, 100);\n" +
                "    1.4 IntStream smallIntegers2 = IntStream.rangeClosed(0, 100);");

        System.out.print("\n    1.1 : ");
        randomNumbers.forEach(t  -> {System.out.printf("%.2f ", t);});

        System.out.print("\n    1.2 : ");
        intStream.forEach(t  -> {System.out.printf("%d ", t);});

        System.out.print("\n    1.3 : ");
        smallIntegers1.forEach(t  -> {System.out.printf("%d ", t);});

        System.out.print("\n    1.4 : ");
        smallIntegers2.forEach(t  -> {System.out.printf("%d ", t);});
        System.out.println();

        // 2 Получить из String - метод .chars()
        IntStream chars = "hello".chars();

        System.out.println("2 Получить из String - метод .chars()");
        System.out.println("Вызов метода chars на строке \"hello\"");
        chars.forEach(System.out::println);
        System.out.println();

        // Порождение Stream
        // 3 Из коллекции
        List<Integer> integerList = List.of(1, 2, 3, 5 ,4 , 5, 6, 8, 7);
        Stream<Integer> integerStream = integerList.stream();
        // IntStream intStream = (IntStream) integerList.stream();

        System.out.println("3 Из коллекции");
        integerStream.forEach(t -> {
            System.out.print(t + " ");
        });
        System.out.println("\n");


        // 4 Stream из BufferedReader
        // https://javarush.ru/groups/posts/593-bufferedreader-i-bufferedwritter
        String fileName = "testBufferedReader.txt";

        System.out.println("4 Stream из BufferedReader");
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Stream<String> stringStream = reader.lines();
            stringStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 5 Из дериктории на диске

        System.out.println("5 Из дериктории на диске");
        Path path = Paths.get("C:\\Projects\\Java_Computer_Science_Center\\StreamAPI");

        try {
            System.out.println("Files.list(path): файлы и директории в указанной директории");
            Stream<Path> stream3 = Files.list(path);
            stream3.forEach(System.out::println);
            System.out.println();
            System.out.println("Files.walk(path): рекурсивный обход всех файлов и директорий в указанной директории");
            Stream<Path> stream4 = Files.walk(path);
            stream4.forEach(System.out::println);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
