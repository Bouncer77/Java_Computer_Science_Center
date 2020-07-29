package com.bouncer77.csc.stepik.les_6_4;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Examples {

    public static void main(String[] args) {

        System.out.println("1 Factorial");
        System.out.println(factorial(4));
        System.out.println(recFactorial(4));
        System.out.println(iterFactorial(4));
        System.out.println();

        System.out.println("2 Palindrome");
        System.out.println("123321 = " + isPalindrome("123321"));
        System.out.println("123377 = " + isPalindrome("123377"));
        System.out.println();

        pseudoRandomStream(13).limit(10).forEach(System.out::println);

        System.out.println(Integer.toBinaryString(13 * 13));
        //            7 6 5 4 3 2 1 0
        //            1 0 1 0 1 0 0 1
        //                  x x x
        //                    x x x

        // mid(169)
        int k = 0b10101001;
        int m1 = 0b010;
        int m2 = 0b100;
        System.out.println(Integer.toBinaryString(k) + " = " + k);
        System.out.println(Integer.toBinaryString(m1) + " = " + m1);
        System.out.println(Integer.toBinaryString(m2) + " = " + m2);

        System.out.println(169 / 10);
        System.out.println(16 % 1000);

        System.out.println(123456);
        System.out.println(123456 / 10);
        System.out.println(12345 % 1000);

    }

    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static long recFactorial(int n) {
        if (n == 1 || n == 0)
            return 1;

        return n * recFactorial(n - 1);
    }

    public static long iterFactorial(int n) {

        long fact = 1;
        if (n == 1 || n == 0)
            return 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder leftToRight = new StringBuilder();

        s.chars().filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(leftToRight::appendCodePoint); //

        StringBuilder rightToLeft = new StringBuilder(leftToRight).reverse();

        return leftToRight.toString().equals(rightToLeft.toString());
    }


    /**
     * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
     * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
     * Первый элемент последовательности устанавливается равным этому числу.
     * Следующие элементы вычисляются по рекуррентной формуле R_{n+1}=mid(R_{n}^2),
     * где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
     * <p>
     * Например, mid(123456)=345.
     * <p>
     * Пример:
     * pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:
     * 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
     */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }
}
