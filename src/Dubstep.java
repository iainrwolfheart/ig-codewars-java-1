import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dubstep {

    public static void main(String[] args) {
        System.out.println("Expected: \"ABC\". Actual: " + "\"" +
                SongDecoder("WUBWUBABCWUB") + "\"");
        System.out.println("Expected: \"R L\". Actual: " + "\"" +
                SongDecoder("RWUBWUBWUBLWUB") + "\"");
    }

    public static String SongDecoder (String song) {

        List<String> words = Arrays.stream(song.split("WUB")).filter(
                ch -> !ch.isBlank()).collect(Collectors.toList());

        String result = "";

        for (String word : words) {
            result += word + " ";
        }

        return result.trim();
    }

}
