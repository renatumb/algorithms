//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

import java.util.TreeMap;
import java.util.TreeSet;

public class XofAkindInDeckOfCards {

    public static void main(String... args) {


    }


    public static boolean hasGroupsSizeX(int[] deck) {

        TreeMap<Integer, Integer> numbers = new TreeMap();
        TreeSet<Integer> qtd = new TreeSet();

        for (int number : deck) numbers.put(number, numbers.getOrDefault(number, 0) + 1);

        for (int q : numbers.values()) qtd.add(q);

        return qtd.size() == 1;


    }

}
