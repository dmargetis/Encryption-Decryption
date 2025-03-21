import java.util.Arrays;
import java.util.List;

public class UnicodeAlgorithm extends Algorithm {

    @Override
    public String encrypt(String text, int key) {
        String[] charArray = text.split("");
        List<String> characterList = Arrays.asList(charArray);
        characterList.replaceAll(character -> encryptCharacter(character, key));
        return listToString(characterList);
    }

    public String encryptCharacter(String character, int key) {
        return String.valueOf((char)(character.charAt(0) + key));
    }

    @Override
    public String decrypt(String text, int key) {
        String[] charArray = text.split("");
        List<String> characterList = Arrays.asList(charArray);
        characterList.replaceAll(character -> decryptCharacter(character, key));
        return listToString(characterList);
    }

    public String decryptCharacter(String character, int key) {
        return String.valueOf((char)(character.charAt(0) - key));
    }

}
