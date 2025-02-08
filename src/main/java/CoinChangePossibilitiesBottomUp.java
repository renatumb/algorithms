public class CoinChangePossibilitiesBottomUp {

    public static void main(String[] args) {

        System.out.println(changePossibilitiesBottomUp(20, new int[]{1, 3, 5}));

    }

    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {

            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {

                int higherAmountRemainder = higherAmount - coin;

                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];

            }
        }
        return waysOfDoingNCents[amount];
    }
}
