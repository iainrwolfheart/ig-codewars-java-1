public class EncryptThisSixKyu {

    public static void main(String[] args) {
        System.out.println("Expected: \nActual: " + encryptThis(""));
        System.out.println("Expected: 65 119esi 111dl 111lw 108dvei 105n 97n 111ka.\n Actual: " + encryptThis("A wise old owl lived in an oak"));
        System.out.println("Expected: 84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp.\n Actual: " + encryptThis("The more he saw the less he spoke"));
        System.out.println("Expected: 84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare.\n Actual: " + encryptThis("The less he spoke the more he heard"));
        System.out.println("Expected: 87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri.\n Actual: " + encryptThis("Why can we not all be like that wise old bird"));
        System.out.println("Expected: 84kanh 121uo 80roti 102ro 97ll 121ruo 104ple.\n Actual: " + encryptThis("Thank you Piotr for all your help"));
    }

    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        String output = "";

        for (String word : words) {
            if(word != null && word.length()!=0) {
                String newWord = "";
                char[] wordChars = word.toCharArray();
                newWord += Integer.toString(wordChars[0]);
                if (wordChars.length > 1) newWord += wordChars[wordChars.length - 1];
                if (wordChars.length > 3) {
                    for (int i = 2; i < wordChars.length - 1; i++) {
                        newWord += wordChars[i];
                    }
                }
                if (wordChars.length > 2) newWord += wordChars[1];

            output += newWord + " ";
            }
        }
        return text.equals("") ? "" : output.trim();
    }
}
