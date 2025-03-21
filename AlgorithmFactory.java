public class AlgorithmFactory {

    public Algorithm getAlgorithm(String type) {
        return switch(type) {
            case "shift" -> new ShiftAlgorithm();
            case "unicode" -> new UnicodeAlgorithm();
            default -> null;
        };
    }
}

