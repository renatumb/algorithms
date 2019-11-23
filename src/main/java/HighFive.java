//https://leetcode.com/problems/high-five/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;


public class HighFive {

    public static void main(String[] args) {

        int[][] x = new int[][]{
                {1, 91},
                {1, 92},
                {2, 93},
                {2, 97},
                {1, 60},
                {2, 77},
                {1, 65},
                {1, 87},
                {1, 100},
                {2, 100},
                {2, 76}
        };
        System.out.println(Arrays.toString(highFive(x)));
    }

    public static int[][] highFive(int[][] items) {

        TreeMap<Integer, ArrayList<Integer>> idScore = new TreeMap<>();

        for (int i = 0; i < items.length; i++) {
            ArrayList<Integer> item = idScore.getOrDefault(items[i][0], new ArrayList());
            item.add(items[i][1]);
            idScore.put(items[i][0], item);
        }
        int[][] result = new int[idScore.size()][2];
        int last = 0;

        for (Integer key : idScore.keySet()) {

            Object[] values = idScore.get(key).toArray();

            Arrays.sort(values);

            result[last][0] = key;
            result[last][1] = Math.round(((Integer) values[values.length - 1] +
                    (Integer) values[values.length - 2] +
                    (Integer) values[values.length - 3] +
                    (Integer) values[values.length - 4] +
                    (Integer) values[values.length - 5]) / 5);
            last++;
        }
        return result;
    }


}