package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Insertion;
import com.jikeshijian.chris.sort1.Shell;

import java.io.*;
import java.util.ArrayList;

/**
 * This is description.
 * 1. Prepare a original_number.txt file contains [1, 100000], like this:
 * original_number.txt:
 * 100000
 * 99999
 * 99998
 * ...
 * 3
 * 2
 * 1
 * and after run the Shell.sort(...) or Insertion.sort(...), generates a reverse_number.txt like this:
 * reverse_number.txt:
 * 1
 * 2
 * 3
 * ...
 * 99998
 * 99999
 * 100000
 *
 * @author Chris Lee
 * @date 2020/7/21 21:25
 */
public class SortCompare {
    public static void main(String[] args) throws IOException {
        // Generate [1, 100000] to a file.
        String fromFileName = "original_number.txt";
        String toFileName = "reverse_number.txt";
        int number = 100000;
        generateFileName(fromFileName, number);

        // 2. Read the number.txt to a Integer[] array.
        Integer[] reverseIntegers = readFromFile(fromFileName, number);

        // 3. Reverse the Integer[] array with Shell Sort and Insertion Sort.
        // Shell sort cost time: 23 ms.
        // testShell(reverseIntegers);

        // Insertion sort cost time: 23796 ms.
        testInsertion(reverseIntegers);

        // 4. Write the reverse Integer[] array to reverse_shell_number.txt and reverse_insertion_number.txt.
        writeToFile(reverseIntegers, toFileName);
    }

    private static void generateFileName(String fileName, int number) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File(fileName)));
        Integer[] integers = new Integer[number];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = number - i;
            writer.write(String.valueOf(integers[i]) + "\n");
        }
        writer.close();
    }

    private static Integer[] readFromFile(String fileName, int number) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
        String line = null;

        Integer[] reverseIntegers = new Integer[number];
        ArrayList<Integer> list = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            list.add(Integer.valueOf(line));
        }
        reader.close();

        // Convert ArrayList to Integer[].
        list.toArray(reverseIntegers);
        return reverseIntegers;
    }

    private static void writeToFile(Integer[] arr, String fileName) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File(fileName)));
        for (int i = 0; i < arr.length; i++) {
            writer.write(String.valueOf(arr[i]) + "\n");
        }
        writer.close();
    }

    private static void testInsertion(Integer[] arr) {
        long start = System.currentTimeMillis();
        Insertion.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Insertion sort cost time: " + (end - start) + " ms.");
    }

    private static void testShell(Integer[] arr) {
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Shell sort cost time: " + (end - start) + " ms.");
    }
}
