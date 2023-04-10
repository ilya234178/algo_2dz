package org.example;
import java.util.Arrays;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 1, 5, 7, 7, 3, 2, 5, 7 };

        // диапазон элементов массива
        int k = 10;
        System.out.println(Arrays.toString(arr));
        countSort(arr, k);
        System.out.println("result : "+
                Arrays.stream(new Integer[]{1, 3, 1, 5, 7, 7, 3, 2, 5, 7})
                        .collect(groupingBy(Function.identity(),counting())));
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int[]arr, int k){
        // создаем целочисленный массив размера `n` для хранения отсортированного массива
        int[] output = new int[arr.length];

        // создать целочисленный массив размером `k + 1`, инициализированный всеми нулями
        int[] freq = new int[k + 1];

        // используя значение каждого элемента входного массива в качестве индекса,
        // сохраняем счетчик каждого целого числа в `freq[]`
        for (int i: arr) {
            freq[i]++;
        }

        // вычисляем начальный индекс для каждого целого числа
        int total = 0;
        for (int i = 0; i < k + 1; i++)
        {
            int oldCount = freq[i];
            freq[i] = total;
            total += oldCount;
        }

        // копируем в выходной массив, сохраняя порядок входов с одинаковыми ключами
        for (int i: arr)
        {
            output[freq[i]] = i;
            freq[i]++;
        }

        // копируем выходной массив обратно во входной массив
        Arrays.setAll(arr, i -> output[i]);
    }


}