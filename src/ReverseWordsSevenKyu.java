public class ReverseWordsSevenKyu {

    public static void main(String[] args) {

        System.out.println(("ehT kciuq nworb xof spmuj revo eht yzal .god | " + reverseWords("The quick brown fox jumps over the lazy dog.")));
        System.out.println(("elppa | " + reverseWords("apple")));
        System.out.println(("a b c d | " + reverseWords("a b c d")));
        System.out.println(("elbuod  decaps  sdrow | " + reverseWords("double  spaced  words")));
    }

    public static String reverseWords(final String original) {
           String currentWord = "";
           String result = "";

           for (int i = 0; i < original.length(); i++) {
               if (original.substring(i, i + 1).equals(" ")) {
                   result += currentWord + " ";
                   currentWord = "";
               } else {
                   currentWord = original.charAt(i) + currentWord;
               }
           }
           return result + currentWord;
    }
}
