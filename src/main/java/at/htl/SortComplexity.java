package at.htl;

import java.util.Scanner;

public class SortComplexity {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int length;
        int amount;
        long sysTime = 0;
        long currentTime = 0;


        System.out.printf("Anzahlt der zu sortierenden: ");
        amount = scanner.nextInt();
        System.out.printf("Größe der Arrays: ");
        length = scanner.nextInt();

        for (int i = 0; i < amount; i++) {
             currentTime = sortRandomArray(length);

            System.out.println("Laufzeit zur Sortierung des "+i+". Arrays: "+ currentTime);

             sysTime += currentTime;
        }
        sysTime /= amount;

        System.out.printf("Durchschnittliche Laufzeit: " + sysTime + "ms");

    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {

        long before = System.currentTimeMillis();
        sort(generateRandomArray(length));
        long after = System.currentTimeMillis();

        long sysTime = after - before;


        return sysTime;
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int)(1 + (Math.random() * (0 + 100)));
        }

        return array;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        int h;

        for (int i = 1; i < array.length; i++) {
            h = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > h){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = h;
        }
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {

    }
}
