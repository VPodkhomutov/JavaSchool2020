package Lesson1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;

public class Lesson1 {
    public static void main(String[] args) {
        //1.1
        System.out.println("Задача 1:");
        System.out.println("Hello World!");
        System.out.println("------------");

        //1.2
        System.out.println("Задача 2:");
        int i = 21;
        int y = 8;
        System.out.println(i + "/" + y + " = " + i / y + " остаток " + i % y);
        System.out.println("------------");

        //1.3
        System.out.println("Задача 3:");
        String s = "2";
        int tmp;
        for (int k = 3; k < 100; k++) {
            tmp = 0;
            for (int m = 2; m < k; m++) {
                if ((k % m) == 0) {
                    tmp++;
                }
            }
            if (tmp == 0) {
                s = s + "," + k;
            }
        }
        System.out.println(s);
        System.out.println("------------");

        //1.4
        System.out.println("Задача 4:");
        System.out.println("Введите число от 2 до 100");
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        //первое решение
        String seqFib = "0, 1";
        long pprev = 0; //на 94 начинается переполнение
        long prev = 1;
        long fib;
        for (int e = 2; e < z; e++) {
            fib = prev + pprev;
            seqFib = seqFib + ", " + fib;
            pprev = prev;
            prev = fib;
        }
        System.out.println(seqFib);
        System.out.println("------------");

        //второе решение
        System.out.println("Задача 4а:");
        long[] arr = new long[z];
        arr[0] = 0;
        arr[1] = 1;
        for (int d = 2; d < arr.length; ++d) {
            arr[d] = arr[d - 1] + arr[d - 2];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("------------");

        //1.5
        System.out.println("Задача 5:");
        int[] arr2 = new int[]{12, 54, 23, 88, 98, 134, 1, 23, 34, 22, 65, 987, 34, 18, 77, 75, 54, 356, 200, 6};
        int[] arr3 = new int[]{12, 54, 23, 88, 98, 134, 1, 23, 34, 22, 65, 987, 34, 18, 77, 75, 54, 356, 200, 6};

        int cnt = 1;
        int tempArr;
        while (cnt > 0) {
            cnt = 0;
            for (int v = 0; v < arr2.length - 1; v++) {
                if (arr2[v] > arr2[v + 1]) {
                    tempArr = arr2[v];
                    arr2[v] = arr2[v + 1];
                    arr2[v + 1] = tempArr;
                    cnt++;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));
        //проверочное решение
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("------------");
    }
}
