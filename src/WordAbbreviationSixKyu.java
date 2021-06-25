public class WordAbbreviationSixKyu {

    public static void main(String[] args) {
        System.out.println("i18n | " + abbreviate("internationalization"));
        System.out.println("e6t-r2e are r4y fun | " + abbreviate("elephant-rides are really fun"));
        System.out.println("b5n-on_m8c: d3y-d4e-b6d: mat; on'b5n | "
                + abbreviate("balloon-on_monolithic: doggy-double-barreled: mat; on'balloon"));


    }

//    public static String abbreviate(String string) {
//        String result = "";
//
//        String[] words = string.split("\\W+");
//
//        for(String word : words) {
//            if (word.length() > 3) {
//                result += word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
//            } else {
//                result += word;
//            }
//            result += " ";
//        }
//        return result.trim();
//    }
    public static String abbreviate(String string) {

        String currentWord = "";
        String result = "";

        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                currentWord += string.charAt(i);
            } else {
                result += checker(currentWord) + string.charAt(i);
                currentWord = "";
            }
        }
        return result + checker(currentWord);
    }

    public static String checker(String word) {
        return word.length() <= 3 ? word : word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    }
}
