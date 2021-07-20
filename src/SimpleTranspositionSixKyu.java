public class SimpleTranspositionSixKyu {

    public static void main(String[] args) {
        System.out.println("EXPECTED: Sml etapetx\nACTUAL: " + simpleTransposition("Sample text"));
        System.out.println("EXPECTED: Sml rnpstoipetasoiin\nACTUAL: " + simpleTransposition("Simple transposition"));
        System.out.println("EXPECTED: Alta ltesi o odl htgitr sntgl\nACTUAL: " + simpleTransposition("All that glitters is not gold"));
        System.out.println("EXPECTED: Tebte ato ao sdsrtoh etrpr fvlri icein\nACTUAL: " + simpleTransposition("The better part of valor is discretion"));
        System.out.println("EXPECTED: Cncec osmk oad fu losinede aecwrso sal\nACTUAL: " + simpleTransposition("Conscience does make cowards of us all"));
        System.out.println("EXPECTED: Iaiaini oeipratta nwegmgnto smr motn hnkolde\nACTUAL: " + simpleTransposition("Imagination is more important than knowledge"));

    }
    public static String simpleTransposition(String text) {

        String row1 = "";
        String row2 = "";

        for (int i = 0; i < text.length(); i++) {
            if ((i + 1) % 2 == 1) {
                row1 += text.charAt(i);
            } else {
                row2 += text.charAt(i);
            }
        }
        return row1 + row2;
    }
}
