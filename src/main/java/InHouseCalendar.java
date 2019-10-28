import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class InHouseCalendar {

    public static void main(String... args) {

        solution(new int[][]{
                {0, 1},
                {10, 12},
                {3, 5},
                {4, 8},
                {9, 10}
        });
    }

    public static void solution(int[][] meetings) {

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] <= o2[0] ? -1 : 1;
            }
        });

        LinkedList<ArrayList<Integer>> answer = new LinkedList();

        for (int[] meet : meetings) {
            ArrayList<Integer> meet2 = new ArrayList();

            meet2.add(meet[0]);
            meet2.add(meet[1]);

            if (answer.isEmpty()) {
                answer.add(meet2);
            } else {
                if (answer.getLast().get(1) >= meet2.get(0)) {
                    answer.getLast().remove(1);
                    answer.getLast().add(meet2.get(1));
                } else
                    answer.add(meet2);
            }
        }
        System.out.println(answer);
    }
}


