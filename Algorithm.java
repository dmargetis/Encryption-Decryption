import java.util.List;

public abstract class Algorithm {

    abstract String encrypt(String text, int key);
    abstract String decrypt(String text, int key);

    public static String listToString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for(String element : list) {
            builder.append(element);
        }
        return builder.toString();
    }
}
