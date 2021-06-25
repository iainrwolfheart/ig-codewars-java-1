import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class StatisticsForAnAthleticAssociationSixKyu {

    public static void main(String[] args) {
        System.out.println("EXPECTED: Range: 01|01|18 Average: 01|38|05 Median: 01|32|34\nACTUAL: " +
                stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
        System.out.println("EXPECTED: Range: 00|31|17 Average: 02|26|18 Median: 02|22|00\nACTUAL: " +
                stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"));
    }

    public static String stat(String strg) {

        ArrayList<Integer> stats = new ArrayList<>();
        int timesTotal = 0;
        for (String time: strg.split(",")) {
            time = time.trim();
            int stat = Integer.parseInt(time.substring(0, time.indexOf("|"))) * 3600
                    + Integer.parseInt(time.substring(time.indexOf("|") + 1, time.lastIndexOf("|"))) * 60
                    + Integer.parseInt(time.substring(time.lastIndexOf("|") + 1));
            timesTotal += stat;
            stats.add(stat);
        }
        Collections.sort(stats);
        int range = Collections.max(stats) - Collections.min(stats);
        int median = stats.size() % 2 == 0 ? (stats.get((stats.size()/2)-1) + stats.get(stats.size()/2))/2 : stats.get((stats.size()/2));
        int mean = timesTotal / stats.size();

        return String.format("Range: %02d|%02d|%02d Average: %02d|%02d|%02d Median: %02d|%02d|%02d",
                range/3600, (range % 3600) / 60, range % 60,
                mean/3600, (mean % 3600) / 60, mean % 60,
                median/3600, (median % 3600) / 60, median % 60
                );

//        if (strg.equals("")) return "";
//
//        HashMap<String, String> formattedAverages = getFormattedAverages(strg);
//
//        return "Range: " + formattedAverages.get("range") +
//                " Average: " + formattedAverages.get("mean") +
//                " Median: " + formattedAverages.get("median");
    }

    private static HashMap<String, String> getFormattedAverages(String strg) {
        HashMap<String, Integer> averagesAsInts = getAveragesInSeconds(strg);
        HashMap<String, String> formattedAverages = new HashMap<>();
        averagesAsInts.forEach((key, value) -> formattedAverages.put(key, reformatTime(value)));

        return formattedAverages;
    }

    private static String reformatTime(Integer timeInSeconds) {
        ArrayList<String> timeElementsAsString = addLeadingZeros(timeInSeconds);
        return timeElementsAsString.get(0) + "|" + timeElementsAsString.get(1) + "|" + timeElementsAsString.get(2);
    }

    private static ArrayList<String> addLeadingZeros(Integer timeInSeconds) {
        ArrayList<Integer> timeElements = convertSecondsToHoursMinsSecs(timeInSeconds);
        ArrayList<String> timeElementsAsStrings = new ArrayList<>();
        timeElements.forEach(time -> timeElementsAsStrings.add(String.format("%02d", time)));

        return timeElementsAsStrings;
    }

    private static ArrayList<Integer> convertSecondsToHoursMinsSecs(Integer timeInSeconds) {
        ArrayList<Integer> listOfTimeElements = new ArrayList<>();
        listOfTimeElements.add(timeInSeconds / 3600);
        listOfTimeElements.add((timeInSeconds % 3600) / 60);
        listOfTimeElements.add(timeInSeconds % 60);

        return listOfTimeElements;
    }

    private static HashMap<String, Integer> getAveragesInSeconds(String strg) {
        ArrayList<Integer> timesInSeconds = getAllTimesInSeconds(strg);
        HashMap<String, Integer> averagesAsInts = new HashMap<>();
        averagesAsInts.put("range", getRange(timesInSeconds));
        averagesAsInts.put("mean", getMean(timesInSeconds));
        averagesAsInts.put("median", getMedian(timesInSeconds));

        return averagesAsInts;
    }

    private static int getRange(ArrayList<Integer> timesInSeconds) {
        return Collections.max(timesInSeconds) - Collections.min(timesInSeconds);
    }

    private static int getMean(ArrayList<Integer> timesInSeconds) {
        return sumIntArrayList(timesInSeconds) / timesInSeconds.size();
    }

    private static int getMedian(ArrayList<Integer> timesInSeconds) {
        Collections.sort(timesInSeconds);
        return timesInSeconds.size() % 2 == 0 ? getEvenMedian(timesInSeconds) : getOddMedian(timesInSeconds);
    }

    private static int getEvenMedian(ArrayList<Integer> timesInSeconds) {
        ArrayList<Integer> middleListValues = new ArrayList<>();
        middleListValues.add(timesInSeconds.get(timesInSeconds.size() / 2));
        middleListValues.add(timesInSeconds.get((timesInSeconds.size() / 2) - 1));

        return getMean(middleListValues);
    }

    private static int getOddMedian(ArrayList<Integer> timesInSeconds) {
        return timesInSeconds.get(timesInSeconds.size() / 2);
    }

    private static int sumIntArrayList(ArrayList<Integer> timesInSeconds) {
        int sum = 0;
        for (Integer time : timesInSeconds) {
            sum += time;
        }
        return sum;
    }

    private static ArrayList<Integer> getAllTimesInSeconds(String strg) {
        ArrayList<Integer> timesInSeconds = new ArrayList<>();
        for (ArrayList<String> times : getGraphOfTimes(strg)) {
            timesInSeconds.add(getIndividualTimeInSeconds(times));
        }
        return timesInSeconds;
    }

    private static int getIndividualTimeInSeconds(ArrayList<String> times) {
        return (Integer.parseInt(times.get(0)) * 60 * 60)
                + (Integer.parseInt(times.get(1)) * 60)
                + Integer.parseInt(times.get(2));
    }

    private static ArrayList<ArrayList<String>> getGraphOfTimes(String strg) {
        ArrayList<String> timesAsStringArr = getTimesAsStringList(strg, ", ");
        ArrayList<ArrayList<String>> graphOfTimes = new ArrayList<>();
        for (int i = 0; i < timesAsStringArr.size(); i++) {
            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(timesAsStringArr.get(i).split("\\|")));
            graphOfTimes.add(tempList);
            System.out.println(graphOfTimes.get(i));
        }
        return graphOfTimes;
    }

    private static ArrayList<String> getTimesAsStringList(String timesAsString, String splitter) {
        return new ArrayList(Arrays.asList(timesAsString.split(splitter)));
    }
}
