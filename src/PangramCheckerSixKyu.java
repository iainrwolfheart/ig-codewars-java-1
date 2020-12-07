

public class PangramCheckerSixKyu {
    public static void main(String[] args) {

        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        System.out.print(pangram1 + "\n" +
                "Expected: true\n" +
                "Actual: " + check(pangram1) + "\n");

        String pangram2 = "You shall not pass!";
        System.out.print(pangram2 + "\n" +
                "Expected: false\n" +
                "Actual: " + check(pangram2) + "\n");
    }

    public static boolean check(String sentence){

        boolean[] foundChars = new boolean[26];

        int index;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') {
                index = sentence.charAt(i) - 'A';
                foundChars[index] = true;
            } else if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
                index = sentence.charAt(i) - 'a';
                foundChars[index] = true;
            }
        }

        for (boolean isFound : foundChars) {
            if (!isFound) return false;
        }

        return true;
    }

}
