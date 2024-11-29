package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество элементов массива: ");
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Integer[] array = new Integer[len];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < len; i++) {
            array[i] = in.nextInt();
        }

        try {
            double avg = Arrays.stream(array)
                    .filter(n -> n % 2 == 0) // Фильтруем четные числа
             .mapToInt(Integer::intValue) // Преобразуем в IntStream
                    .average() // Вычисляем среднее значение
                    .orElse(0.0); // Если нет четных чисел, возвращаем 0.0

            System.out.println("Среднее значение четных элементов: " + avg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}