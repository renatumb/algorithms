//https://www.interviewcake.com/question/java/mesh-message?course=fc1&section=trees-graphs

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class MeshMessage {

    public static void main(String[] args) {

        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min", new String[]{"William", "Jayden", "Omar"});
            put("William", new String[]{"Min", "Noam"});
            put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
            put("Ren", new String[]{"Jayden", "Omar"});
            put("Amelia", new String[]{"Jayden", "Adam", "Miguel"});
            put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
            put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
            put("Noam", new String[]{"Nathan", "Jayden", "William"});
            put("Omar", new String[]{"Ren", "Min", "Scott"});

        }};
        findPath(network, "Jayden", "Adam");
    }

    public static void findPath(Map<String, String[]> network, String source, String dest) {


        LinkedList<String> nodes = new LinkedList<>();
        TreeMap<String, String> visited = new TreeMap();

        nodes.add("0_" + source);

        while (!nodes.isEmpty()) {
            String current = nodes.pollFirst();

            int steps = Integer.parseInt(current.split("_")[0]);
            current = current.split("_")[1];


            if (current.equals(dest)) {
                System.out.println("Found: " + steps + " " + current);
                break;
            }
            for (String node : network.get(current)) {
                if (!visited.containsKey(node))
                    nodes.add((steps + 1) + "_" + node);
            }
        }

    }
}
