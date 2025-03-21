import java.util.Arrays;
import java.util.List;

public class ShiftAlgorithm  extends Algorithm{

    @Override
    public String encrypt(String text, int key) {
        String[] charArray = text.split("");
        List<String> characterList = Arrays.asList(charArray);
        characterList.replaceAll(character -> encryptCharacter(character, key));
        return listToString(characterList);
    }

    public String encryptCharacter(String character, int key) {
        if(character.matches("[a-z]")) {
            return String.valueOf((char)((character.charAt(0) + key - 'a') % 26 + 'a'));
        }
        else if(character.matches("[A-Z]")) {
            return String.valueOf((char)((character.charAt(0) + key - 'A') % 26 + 'A'));
        }
        else return character;
    }

    @Override
    public String decrypt(String text, int key) {
        String[] charArray = text.split("");
        List<String> characterList = Arrays.asList(charArray);
        characterList.replaceAll(character -> decryptCharacter(character, key));
        return listToString(characterList);
    }

    public String decryptCharacter(String character, int key) {
        if(character.matches("[a-z]")) {
            return String.valueOf((char)((26 + character.charAt(0) - key - 'a') % 26 + 'a'));
        }
        else if(character.matches("[A-Z]")) {
            return String.valueOf((char)((26 + character.charAt(0) - key - 'A') % 26 + 'A'));
        }
        else return character;
    }
}
