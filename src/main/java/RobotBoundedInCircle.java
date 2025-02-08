//https://leetcode.com/problems/robot-bounded-in-circle/

public class RobotBoundedInCircle {

    public static void main(String[] args) {
        //System.out.println(isRobotBounded("GGLLGG"));
        //System.out.println(isRobotBounded("GG"));
        // System.out.println(isRobotBounded("GL"));
        //System.out.println( isRobotBounded2("GLGLGGLGL") );
        System.out.println(isRobotBounded("GLRLLGLL"));
    }

    public static boolean isRobotBounded(String instructions) {
        int r = 0, l = 0, g = 0;
        for (char c : instructions.toUpperCase().toCharArray()) {
            if (c == 'R') {
                if (l == 0) r++;
                else l--;
            } else if (c == 'L') {
                if (r == 0) l++;
                else r--;
            } else {
                g++;
            }
        }
        return r > 0 || l > 0 || g == 0;
    }

    public static boolean isRobotBounded2(String ins) {
        int[] moves = new int[4]; //dirs = new int[]{0,1,2,3}
        int d = 0;
        for (char c : ins.toCharArray()) {
            if (c == 'L')
                d = (d + 4 - 1) % 4;
            if (c == 'R')
                d = (d + 1) % 4;
            if (c == 'G')
                moves[d]++;
        }
        return d != 0 || (moves[0] == moves[2] && moves[1] == moves[3]);
    }
}
