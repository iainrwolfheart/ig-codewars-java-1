public class Break_camelCaseSevenKyu {

    public static void main(String[] args) {

        System.out.println(( "camel Casing | " + camelCase("camelCasing")));
        System.out.println(( "camel Casing Test | " + camelCase("camelCasingTest")));
        System.out.println(( "camelcasingtest | " + camelCase("camelcasingtest")));
    }

    public static String camelCase(String input) {

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                result += " ";
            }
                result += input.charAt(i);
        }
        return result;
    }
}
