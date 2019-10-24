// https://leetcode.com/problems/the-maze-ii/

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

    public static void main(String... args) {

        System.out.println(
                shortestDistance(
                        new int[][]{
                                {0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {1, 1, 0, 1, 1},
                                {0, 0, 0, 0, 0}
                        },
                        new int[]{0, 4},
                        new int[]{4, 4}
                )

        );
    }

    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {

        Integer[][] distance = new Integer[maze.length][maze[0].length];
        distance[start[0]][start[1]] = 0;

        Queue<int[]> queue = new LinkedList<int[]>();

        queue.add(start);

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int i, count;
            //////////////////////////////////////////////////////////////////////////////////////////////
            // increase line
            count = distance[current[0]][current[1]];
            for (i = current[0] + 1; i < maze.length && maze[i][current[1]] != 1; i++) {
                if (maze[i][current[1]] == 0)
                    count++;
            }
            i--;
            if (distance[i][current[1]] == null || distance[i][current[1]] > count) {
                distance[i][current[1]] = count;
                queue.add(new int[]{i, current[1]});
            }//////////////////////////////////////////////////////////////////////////////////////////////
            //
            // increase column
            count = distance[current[0]][current[1]];
            for (i = current[1] + 1; i < maze.length && maze[current[0]][i] != 1; i++) {
                if (maze[current[0]][i] == 0)
                    count++;
            }
            i--;
            if (distance[current[0]][i] == null || distance[current[0]][i] > count && i != current[1]) {
                distance[current[0]][i] = count;
                queue.add(new int[]{current[0], i});
            }//////////////////////////////////////////////////////////////////////////////////////////////
            //
            // decrease line
            count = distance[current[0]][current[1]];
            for (i = current[0] - 1; i >= 0 && maze[i][current[1]] != 1; i--) {
                if (maze[i][current[1]] == 0)
                    count++;
            }
            i++;
            if (distance[i][current[1]] == null || distance[i][current[1]] > count) {
                distance[i][current[1]] = count;
                queue.add(new int[]{i, current[1]});
            }//////////////////////////////////////////////////////////////////////////////////////////////
            // decrease column
            count = distance[current[0]][current[1]];
            for (i = current[1] - 1; i >= 0 && maze[current[0]][i] != 1; i--) {
                if (maze[current[0]][i] == 0)
                    count++;
            }
            i++;
            if (distance[current[0]][i] == null || distance[current[0]][i] > count) {
                distance[current[0]][i] = count;
                queue.add(new int[]{current[0], i});
            }//////////////////////////////////////////////////////////////////////////////////////////////
        }
        return distance[destination[0]][destination[1]] == null ? -1 : distance[destination[0]][destination[1]];
    }
}
