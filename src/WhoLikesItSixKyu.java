public class WhoLikesItSixKyu {

    public static void main(String[] args) {

        System.out.println("Expected: no one likes this\nActual: " + whoLikesIt());
        System.out.println("Expected: Peter likes this\nActual: " + whoLikesIt("Peter"));
        System.out.println("Expected: Jacob and Alex like this\nActual: " + whoLikesIt("Jacob", "Alex"));
        System.out.println("Expected: Max, John and Mark like this\nActual: " + whoLikesIt("Max", "John", "Mark"));
        System.out.println("Expected: Alex, Jacob and 2 others like this\nActual: " + whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 0:
                return "no one likes this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + ", " + names[1] +  " and " + (names.length - 2) + " others like this";
        }
    }
}
