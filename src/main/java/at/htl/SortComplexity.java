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

            System.out.println("Laufzeit zur Sortierung des " + (i+1) + ". Arrays: " + currentTime);

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
            array[i] = (int) (1 + (Math.random() * (0 + 100)));
        }
        return array;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]){
                    swap(array, i, j);
                }
            }
        }
    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int h;

        h = array[j];
        array[j] = array[j+1];
        array[j+1] = h;
    }
}
