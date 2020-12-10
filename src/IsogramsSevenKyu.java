public class IsogramsSevenKyu {

    public static void main(String[] args) {
        System.out.println("Expected: true, Actual: " + isIsogram("isogram"));
        System.out.println("Expected: true, Actual: " + isIsogram("Dermatoglyphics"));
        System.out.println("Expected: false, Actual: " + isIsogram("moose"));
        System.out.println("Expected: false, Actual: " + isIsogram("isIsogram"));
        System.out.println("Expected: false, Actual: " + isIsogram("aba"));
        System.out.println("Expected: false, Actual: " + isIsogram("moOse"));
        System.out.println("Expected: true, Actual: " + isIsogram("thumbscrewjapingly"));
        System.out.println("Expected: true, Actual: " + isIsogram(""));
    }

    public static boolean isIsogram(String str) {
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (str.lastIndexOf(str.charAt(i)) != str.indexOf(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
