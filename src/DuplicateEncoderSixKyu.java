import java.util.HashMap;

public class DuplicateEncoderSixKyu {

    public static void main(String[] args) {

        System.out.println("Expected: \")()())()(()()(\"\n" +
                        "Actual: \"" + encode("Prespecialized") + "\"");

        System.out.println("Expected: \"))))())))\"\n" +
                "Actual: \"" + DuplicateEncoderSixKyu.encode("   ()(   ") + "\"");

    }

    static String encode(String word){

        HashMap<Character, Integer> charMap = new HashMap<>(26);
        String result = "";
        char foundChar;
        int i;

//        populate HashMap w/ASCII chars (though not all, so some test may fail)
        for (char ch = 32 ; ch <= 126; ch++) {
            charMap.put(ch, 0);
        }

//        iterate through input String and increment instances of a-z in HashMap
        for (i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) >= 32 && word.toLowerCase().charAt(i) <= 126) {
                foundChar = word.toLowerCase().charAt(i);
                Integer temp = charMap.get(foundChar);
                charMap.put(foundChar, temp.intValue()+1);
            }
        }

//        iterate through input String (again) and replace letters w/relevant character
        for (i = 0; i < word.length(); i++) {
            foundChar = word.toLowerCase().charAt(i);

            if (charMap.get(foundChar) == 1) {
                result += "(";
            } else if (charMap.get(foundChar) > 1) {
                result += ")";
            } else {
                result += foundChar;
            }
        }

        return result;
    }
}
