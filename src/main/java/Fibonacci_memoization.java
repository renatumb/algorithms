import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class Fibonacci_memoization {

    public static void main(String[] args) {
        /*
            System.out.println( fibo_recursiveMemo( 30, 1, new HashMap<>() ) + "\n\n");
            System.out.println( fibo_recursive( 30, 1) + "\n\n"); */


        TreeSet<String> t = new TreeSet();

        t.add("A");
        t.add("B");
        t.add("C");

        TreeSet<String> u = t;

        for (String x : t) {
            System.out.println(x);
            u.add("" + new Date());
        }

    }


    public static int fibo_recursiveMemo(int n, int calls, HashMap<Integer, Integer> found) {
        System.out.println(calls);
        if (n <= 1) {
            return n;
        }

        if (!found.containsKey(n))
            found.put(n, fibo_recursiveMemo(n - 1, calls + 1, found) + fibo_recursiveMemo(n - 2, calls + 1, found));
        return found.get(n);
    }

    public static int fibo_recursive(int n, int calls) {
        System.out.println(calls);
        if (n <= 1) return n;
        return fibo_recursive(n - 1, calls + 1) + fibo_recursive(n - 2, calls + 1);
    }
}
