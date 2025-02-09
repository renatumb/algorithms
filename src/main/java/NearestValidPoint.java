/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
 */

public class NearestValidPoint {

    public static void main(String[] args) {
        NearestValidPoint obj = new NearestValidPoint();

        System.out.println(obj.nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        System.out.println(obj.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        System.out.println(obj.nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }


    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallestDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int tmpDistance = (x - points[i][0]) + (y - points[i][1]);
                tmpDistance = tmpDistance < 0 ? -tmpDistance : tmpDistance;

                if (tmpDistance < smallestDistance) {
                    smallestDistance = tmpDistance;
                    index = i;
                }
            }
        }
        return index;
    }
}
