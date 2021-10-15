import java.util.ArrayList;

public class BinaryToTextSixKyu {

    public static void main(String[] args) {
        System.out.println("EXPECTED: Hello. ACTUAL: " + binaryToText("0100100001100101011011000110110001101111"));
        System.out.println("EXPECTED: '  '. ACTUAL: " + binaryToText(""));
    }

    public static String binaryToText(String binary) {

        ArrayList<String> binaryList = new ArrayList<>();

        for (int i = 0; i < binary.length() - 1; i += 8) {
            binaryList.add(binary.substring(i, Math.min(binary.length(), i + 8)));
        }

        StringBuilder output = new StringBuilder();
        binaryList.stream().forEach(ele -> output.append((char) Integer.parseInt(ele, 2)));

        return output.toString();
    }
}
