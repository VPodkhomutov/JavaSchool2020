package ru.slava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //lesson 1.1
        //System.out.println(Integer.toString(a + b));
        System.out.println(a + b);

        //lesson 1.2
        int[] s = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int sum = alter_summ(s);
        System.out.println(sum);

        //lesson 1.3
        int[] s1 = new int[]{10, 21, 35, 7, 6, 15, 4, 33, 25, 1};
        Arrays.sort(s1);
        System.out.println(s1[0]);

        //lesson 1.4
        List<Integer> l;
        l=circle_number(8,80);
        String str="";
        for (int d:l) { str=str+d+","; }
        System.out.println(str.substring(0,str.length()-1));
    }

    static int alter_summ(int[] a){
        int tmp =a[0];
        for (int i=1;i<a.length;i++) {
            if ((i%2)==1) { tmp=tmp+a[i];}
            else {tmp=tmp-a[i];}
        }
        return tmp;
    }


    static List circle_number(int sistem, int final_n) {
        List listA = new ArrayList();
        int i =1;
        while (i<=final_n){
            if ((i%sistem)==0){
                listA.add(i);
            }
            i++;
        }
        return listA;
    }
}
