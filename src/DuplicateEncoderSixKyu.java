import java.util.HashMap;

public class DuplicateEncoderSixKyu {

    public static void main(String[] args) {

        System.out.println("Expected: \")()())()(()()(\"\n" +
                        "Actual: \"" + encodeBetter("Prespecialized") + "\"");

        System.out.println("Expected: \"))))())))\"\n" +
                "Actual: \"" + DuplicateEncoderSixKyu.encodeBetter("   ()(   ") + "\"");

    }

    static String encode(String word){

        HashMap<Character, Integer> charMap = new HashMap<>(26);
        String result = "";
        char foundChar;
        int i;

//        populate HashMap w/ASCII printable chars 'space' -> '~' only (so some tests could fail, but didn't!)
        for (char ch = 32; ch <= 126; ch++) {
            charMap.put(ch, 0);
        }

//        iterate through input String and increment found instances of printable chars in HashMap
        for (i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) >= 32 && word.toLowerCase().charAt(i) <= 126) {
                foundChar = word.toLowerCase().charAt(i);
                Integer temp = charMap.get(foundChar); // Bcz thanks, immutability
                charMap.put(foundChar, temp.intValue()+1);
            } else continue;
        }

//        iterate through input String (again...) and replace letters w/relevant character in output
        for (i = 0; i < word.length(); i++) {
            foundChar = word.toLowerCase().charAt(i);

            if (charMap.get(foundChar) == 1) {
                result += "(";
            } else if (charMap.get(foundChar) > 1) {
                result += ")";
            } else {
                result += foundChar; // Not really needed but resilient, I guess!
            }
        }

        return result;
    }

    static String encodeBetter(String word) {
        word = word.toLowerCase();
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            result += word.lastIndexOf(word.charAt(i)) == word.indexOf(word.charAt(i)) ? "(" : ")";
        }
        return result;
    }
}


