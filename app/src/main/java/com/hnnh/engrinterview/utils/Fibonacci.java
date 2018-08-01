package com.hnnh.engrinterview.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static ArrayList<Integer> getFibonacciNumbers() {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        int a ;
        int b = 0;
        int c = 1;
        System.out.print("Fibonacci Series:");
        for (int i = 1; i <= 100; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");
            fibonacciList.add(a);
        }
        return fibonacciList;
    }
}
