

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class BubbleSort {


    public static void main(String[] args) {
        final int ITEMS = 200_000;

        int[] numbers = new int[ITEMS];


        for (int i = 0; i < ITEMS; i++) {
            numbers[i] = new Random().nextInt(10000);
        }

        System.out.println(Arrays.toString(numbers));


        Runnable t001 = () -> {
            BubbleSort.bubbleSort_regular(numbers);
        };
        Runnable t002 = () -> {
            BubbleSort.bubbleSort_better(numbers);
        };

        new Thread(t001).start();
        new Thread(t002).start();
    }


    public static int[] bubbleSort_regular(final int[] n) {

        int[] numbers = Arrays.copyOf(n, n.length);
        long past = 0;
        boolean next = true;
        Date ini = new Date();
        for (int i = 0; i < numbers.length; i++) {
            next = true;
            for (int j = i; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                    next = false;
                }
                past++;
            }
            if (!next) i--;
        }
        Date end = new Date();

        System.out.println(Thread.currentThread() + " regular Total time: " + (end.toInstant().toEpochMilli() - ini.toInstant().toEpochMilli()) + "ms " + past + " " + Arrays.toString(numbers));
        return numbers;
    }

    public static int[] bubbleSort_better(final int[] n) {

        int[] numbers = Arrays.copyOf(n, n.length);
        long past = 0;
        boolean next = true;
        int last = numbers.length - 1;

        Date ini = new Date();
        for (int i = 0; i < numbers.length; i++) {
            next = true;
            for (int j = i; j < last; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                    next = false;
                }
                past++;
            }
            last--;
            if (!next) i--;
        }
        Date end = new Date();

        System.out.println(Thread.currentThread() + " better  Total time: " + (end.toInstant().toEpochMilli() - ini.toInstant().toEpochMilli()) + "ms " + past + " " + Arrays.toString(numbers));
        return numbers;
    }

}
