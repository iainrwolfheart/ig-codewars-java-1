import java.util.Arrays;

public class WhereIsMyParentSixKyu {

    public static void main(String[] args) {
        System.out.println("Expected: AaBb\nACTUAL: "+ findChildren("abBA"));
        System.out.println("Expected: AaaaaaZzzz\nACTUAL: "+ findChildren("AaaaaZazzz"));
        System.out.println("Expected: AaBbbCcc\nACTUAL:"+ findChildren("CbcBcbaA"));
        System.out.println("Expected: FfUuuuXx\nACTUAL: "+ findChildren("xXfuUuuF"));
        System.out.println("Expected:  \nACTUAL: "+ findChildren(""));
    }

    static String findChildren(final String text) {

        char[] textAsArray = text.toCharArray();

        Arrays.sort(textAsArray);

        for (int i = 0; i < textAsArray.length - 1; i++) {
            for (int j = 1; j < textAsArray.length - i; j++) {
                char testCur = textAsArray[j - 1] >= 97 ? (char) (textAsArray[j - 1] - 32) : textAsArray[j - 1];
                char testNext = textAsArray[j] >= 97 ? (char) (textAsArray[j] - 32) : textAsArray[j];
                if (testCur > testNext) {
                    char temp = textAsArray[j - 1];
                    textAsArray[j - 1] = textAsArray[j];
                    textAsArray[j] = temp;
                } 
            }
        }

        return String.valueOf(textAsArray);
    }
}
