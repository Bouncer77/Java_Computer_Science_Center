package com.bouncer77.csc.stepik.les_6_4;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiIntermediateOperations {
    public static void main(String[] args) {

        // Пример 1

        System.out.println("int sum = IntStream.iterate(1, n -> n + 1) // получение Stream\n" +
                "                // Операции преобразование 0 или более\n" +
                "                .filter(n -> n % 5 == 0 && n % 2 != 0) // 1\n" +
                "                .limit(10) // 2\n" +
                "                .map(n -> n * n) // 3\n" +
                "                .sum(); // терминальная операция\n");

        System.out.println("Пример 1");
        int sum = IntStream.iterate(1, n -> n + 1) // получение Stream
                // Операции преобразование 0 или более
                .filter(n -> n % 5 == 0 && n % 2 != 0) // 1
                .limit(10) // 2
                .map(n -> n * n) // 3
                .sum(); // терминальная операция

        // если Stream выделял системные ресурсы, то нужно вызвать метод .close()
        System.out.println("1. Сгенерировать на месте вызова");
        System.out.println("    1.1 Получение Stream: Сумма целый чисел от 1 до бесконечности с шагом +1\n" +
                "    1.2 Предикат:\n" +
                "        1.2.1 filter | Оставить кратные 5 и отбросить четные\n" +
                "        1.2.2 limit | лимит 10 шт\n" +
                "        1.2.3 map | возведенные в квадрат\n" +
                "    1.3 sum | терминальная операция\n" +
                "Сумма стрима: " + sum);

        // Пример 2
        IntStream intStream = IntStream.iterate(100, n -> n + 1)
                .filter(n -> n > 100) // фильтрация
                .mapToObj(Integer::toString) // из каждого элемента делает другой элемент с другим типом
                .flatMapToInt(String::chars) // возвращает Stream и конкатенирует их в один IntStream
                //.peek(System.out::println)// .peek(new Consumer<>()) // подсмотреть элименты
                .distinct() // убрать дубликаты
                .sorted() // отсортировать по возрастанию (можно передать Comparator)
                .skip(3) // пропустить 3 первых элемента
                .limit(2); // ограничить заданным количеством

        intStream.forEach(System.out::println);

    }

}
