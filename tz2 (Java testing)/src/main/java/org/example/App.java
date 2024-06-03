package org.example;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.io.*;

public class App {

    public static long findMinimum(ArrayList<Long> data) {
        return data.get(0);
    }

    public static long findMaximum(ArrayList<Long> data) {
        long maxVal = data.get(0);
        for (long element : data) {
            if (element > maxVal) {
                maxVal = element;
            }
        }
        return maxVal;
    }

    public static String computeSum(ArrayList<Long> data) {
        BigInteger total = BigInteger.ZERO;
        for (long element : data) {
            total = total.add(BigInteger.valueOf(element));
        }
        return total.toString();
    }

    public static String computeProduct(ArrayList<Long> data) {
        BigInteger product = BigInteger.ONE;
        for (long element : data) {
            product = product.multiply(BigInteger.valueOf(element));
        }
        return product.toString();
    }

    public static ArrayList<Long> loadNumbers(String filePath) throws IOException {
        ArrayList<Long> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String values = reader.readLine();
            for (String value : values.split(" ")) {
                numbers.add(Long.valueOf(value));
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Long> numbers = loadNumbers("test.txt");
            System.out.println("Min: " + findMinimum(numbers));
            System.out.println("Max: " + findMaximum(numbers));
            System.out.println("Sum: " + computeSum(numbers));
            System.out.println("Mult: " + computeProduct(numbers));
        } catch (IOException e) {
            System.err.println("Error processing");
        }
    }
}