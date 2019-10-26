//https://leetcode.com/problems/shifting-letters/
public class ShiftingLetters {

    public static void main(String... args) {


        System.out.println(shiftingLetters("abc", new int[]{3, 5, 9}));
        System.out.println(shiftingLetters2("abc", new int[]{3, 5, 9}));

        System.out.println(shiftingLetters("bad", new int[]{10, 20, 30}));
        System.out.println(shiftingLetters2("bad", new int[]{10, 20, 30}));

        System.out.println(
                shiftingLetters("mkgfzkkuxownxvfvxasy",
                        new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}
                )
        );

        System.out.println(
                shiftingLetters2("mkgfzkkuxownxvfvxasy",
                        new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}
                )
        );


    }

    public static String shiftingLetters(String S, int[] shifts) {

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < shifts.length; i++) shifts[i] = shifts[i] % letters.length;

        for (int i = shifts.length - 2; i >= 0; i--)
            shifts[i] = shifts[i] + shifts[i + 1];

        char[] result = S.toCharArray();

        for (int i = 0; i < result.length; i++) {
            int t = (((int) result[i] - 97) + shifts[i]) % letters.length;
            result[i] = letters[t];
        }
        return new String(result);
    }

    public static String shiftingLetters2(String S, int[] shifts) {

        for (int i = 0; i < shifts.length; i++) shifts[i] = shifts[i] % 26;

        for (int i = shifts.length - 2; i >= 0; i--)
            shifts[i] = shifts[i] + shifts[i + 1];

        char[] result = S.toCharArray();

        for (int i = 0; i < result.length; i++) {
            int t = (((int) result[i] - 97) + shifts[i]) % 26;
            result[i] = (char) (t + 97);
        }
        return new String(result);
    }

}
