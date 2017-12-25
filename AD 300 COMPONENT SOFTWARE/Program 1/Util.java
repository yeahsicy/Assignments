package com.company;

import java.util.*;

public class Util {
    private static Scanner Temp;
    private static ArrayList<Integer> ListInts = new ArrayList<>();
    public static Integer[] ArrInts;

    //Place integers into array ArrInts from Console.
    public static void SetArray(int capacity) {
        for (int i = 1; i <= capacity; i++) {
            System.out.println("Please enter integer " + i);
            Temp = new Scanner(System.in);
            if (Temp.hasNextInt())
                ListInts.add((Temp.nextInt()));
            else {
                System.out.println("Sorry, we can't recognize your input. ");
                i--;
            }
        }
        ArrInts = ListInts.toArray(new Integer[0]);
    }

    //Get the average of array ArrInts.
    public static double GetAverage() {
        double total = 0;
        for (int i : ArrInts)
            total += i;
        return total / ArrInts.length;
    }
}

