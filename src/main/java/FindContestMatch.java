import java.util.LinkedList;

// https://leetcode.com/problems/output-contest-matches/
public class FindContestMatch {


    public static void main(String... args) {
        System.out.println(findContestMatch(8));
    }

    public static String findContestMatch(int n) {

        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> tmp;

        for (int i = 1; i <= n; i++) result.add("" + i);

        while (result.size() > 1) {

            tmp = new LinkedList<>();

            while (!result.isEmpty()) {
                tmp.add("(" + result.pollFirst() + "," + result.pollLast() + ")");
            }
            result = tmp;
        }
        return result.pollFirst();
    }

}
