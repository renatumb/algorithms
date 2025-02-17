//https://www.interviewcake.com/question/java/cake-thief?course=fc1&section=dynamic-programming-recursion

public class CakeThief {

    public static void main(String[] args) {


        System.out.println(maxDuffelBagValue(
                new CakeType[]{
                        new CakeType(7, 160),
                        new CakeType(3, 90),
                        new CakeType(2, 15),
                },
                10
        ));

    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // we make an array to hold the maximum possible value at every
        // duffel bag weight capacity from 0 to weightCapacity
        // starting each index with value 0
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            // set a variable to hold the max monetary value so far for currentCapacity
            long currentMaxValue = 0;

            for (CakeType cakeType : cakeTypes) {

                // if a cake weighs 0 and has a positive value the value of our duffel bag is infinite!
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                // if the current cake weighs as much or less than the current weight capacity
                // it's possible taking the cake would get a better value
                if (cakeType.weight <= currentCapacity) {

                    // so we check: should we use the cake or not?
                    // if we use the cake, the most kilograms we can include in addition to the cake
                    // we're adding is the current capacity minus the cake's weight. we find the max
                    // value at that integer capacity in our array maxValuesAtCapacities
                    long maxValueUsingCake = cakeType.value
                            + maxValuesAtCapacities[currentCapacity - cakeType.weight];

                    // now we see if it's worth taking the cake. how does the
                    // value with the cake compare to the currentMaxValue?
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            // add each capacity's max value to our array so we can use them
            // when calculating all the remaining capacities
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacities[weightCapacity];
    }

}

class CakeType {
    int weight;
    int value;

    CakeType(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }
}

class InfinityException extends RuntimeException {
    public InfinityException() {
        super("Max value is infinity!");
    }
}
