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

        for (char ch = 'a'; ch <= 'z'; ch++) {
            charMap.put(ch, 0);
        }

        for (i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) >= 'a' && word.toLowerCase().charAt(i) <= 'z') {
              foundChar = word.toLowerCase().charAt(i);
              Integer temp = charMap.get(foundChar);
              charMap.put(foundChar, temp.intValue()+1);
          }
        }

        for (i = 0; i < word.length(); i++) {
            foundChar = word.toLowerCase().charAt(i);
            switch(charMap.get(foundChar)) {
                case 1 :
                    result += "(";
                    break;
                case 2 :
                    result += ")";
                    break;
                default :
                    break;
            }
        }

        return result;
    }
}
