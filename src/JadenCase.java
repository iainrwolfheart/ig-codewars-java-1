
    public class JadenCase {

//        public static void main(String[] args) {
//            System.out.println(toJadenCase("most trees are blue"));
//        }

        public static String toJadenCase(String phrase) {
            if (phrase == null || phrase.equals("")) return null;
            String result = phrase.substring(0,1).toUpperCase();
            for (int i = 1; i < phrase.length(); i++) {
                if (phrase.charAt(i - 1) == ' ') {
                    result += Character.toUpperCase(phrase.charAt(i));
                } else result += phrase.charAt(i);
            }
            return result;
        }
}
