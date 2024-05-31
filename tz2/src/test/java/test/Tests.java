package test;

import org.example.App;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {

    private ArrayList<Long> numbers;

    @BeforeAll
    public void init() throws Exception {
        numbers = App.loadNumbers("test2.txt");
    }

    @Test
    public void testMin() throws IOException {
        assertEquals(Long.valueOf(-1872), App.findMinimum(numbers));
        System.out.println("Test_min complete");
    }

    @Test
    public void testMax() throws IOException {
        assertEquals(Long.valueOf(1965), App.findMaximum(numbers));
        System.out.println("Test_max complete");
    }

    @Test
    public void testSum() throws IOException {
        assertEquals(String.valueOf(-6228), App.computeSum(numbers));
        System.out.println("Test_sum comlete");
    }

    @Test
    public void testMult() throws IOException {
        assertEquals("1649184597210897186487736832000", App.computeProduct(numbers));
        System.out.println("Test_mult complete");
    }

    @Disabled
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeoutFail() {
        ArrayList<Long> largeNumbers = new ArrayList<>();
        for (long i = 1; i <= 100000; i++) {
            largeNumbers.add(i);
        }
        App.computeProduct(largeNumbers);
    }

    @Test
    public void testMultPerformance() {
        int[] sizes = {100, 10000, 100000, 500000, 1000000};
        for (int size : sizes) {
            ArrayList<Long> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                numbers.add((long)(Math.random() * 1000));
            }
            long startTime = System.nanoTime();
            App.computeProduct(numbers);
            long endTime = System.nanoTime();
            long duration_mult = (endTime - startTime) / 1000000;
            startTime = System.nanoTime();
            App.computeSum(numbers);
            endTime = System.nanoTime();
            long duration_sum = (endTime - startTime) / 1000000;
            System.out.println("Size: " + size + ", Time_mult: " + duration_mult + " ms; Time_sum: " + duration_sum + " ms");
        }
    }
}
