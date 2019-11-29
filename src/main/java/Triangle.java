//https://leetcode.com/problems/triangle

import java.util.ArrayList;
import java.util.List;


public class Triangle {

    public static void main(String[] args) {


        List<List<Integer>> row = new ArrayList();

        ArrayList<Integer> r1 = new ArrayList();
        ArrayList<Integer> r2 = new ArrayList();
        ArrayList<Integer> r3 = new ArrayList();
        ArrayList<Integer> r4 = new ArrayList();

        row.add(r1);
        row.add(r2);
        row.add(r3);
        row.add(r4);

        r1.add(2);
        r2.add(3);
        r2.add(4);
        r3.add(6);
        r3.add(5);
        r3.add(7);
        r4.add(4);
        r4.add(1);
        r4.add(8);
        r4.add(3);

        System.out.println(minimumTotal(row));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        for (int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);

            for (int col = 0; col < currentRow.size(); col++) {
                int value = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)) + currentRow.get(col);
                currentRow.set(col, value);
            }
        }
        return triangle.get(0).get(0);

        //return minFound( triangle, 0,0);
    }

    private static int minFound(List<List<Integer>> triangle, int row, int col) {

        int current = triangle.get(row).get(col);
        if (row == triangle.size() - 1)
            return current;

        int left = minFound(triangle, row + 1, col);
        int right = minFound(triangle, row + 1, col + 1);

        return Math.min(left, right) + current;
    }


}
