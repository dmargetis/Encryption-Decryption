/*
Choices, choices
Description
Extend your program by adding different algorithms for encoding/decoding. The first one is the shifting algorithm — it shifts each letter by the specified number according to its order in the alphabet. The second one is based on the Unicode table, like in the previous stage.

Objectives
When starting the program, the necessary algorithm should be specified by an argument (-alg). Name the first algorithm as shift, the second one as unicode. If there is no -alg argument, default it to shift.

Remember that in case of shift, encode only English letters — from "a" to "z" and from "A" to "Z". In other words, after "z" comes "a", after "Z" comes "A".

Examples
Example 1: reading and writing to files; the arguments are: -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

This command must get data from road_to_treasure.txt, encrypt the data with the key of 5, create protected.txt, and write ciphertext into it.

Example 2: encryption with the unicode algorithm; the arguments are: -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode

\jqhtrj%yt%m~ujwxpnqq&

Example 3: decryption with the unicode algorithm; the arguments are: -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

Welcome to hyperskill!

Example 4: encryption with the shift algorithm; the arguments are: -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc

Bjqhtrj yt mdujwxpnqq!

Example 5: decryption with the shift algorithm; the arguments are: -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec

Welcome to hyperskill!

 */

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
        String alg = "shift";

        if(!areArgumentsValid(args)) {
            System.out.println("Error: Arguments are not valid.");
            System.exit(0);
        }

        List<String> arguments = Arrays.asList(args);

        for(int i = 0; i < arguments.size(); i +=2) {
            String next = arguments.get(i + 1);
            switch (arguments.get(i)) {
                case "-mode" -> mode = next;
                case "-key" -> {
                    try {
                        key = Integer.parseInt(next);
                    } catch (NumberFormatException ex) {
                        System.out.println("Not valid key argument");
                    }
                }
                case "-data" -> data = next;
                case "-in" -> in = next;
                case "-out" -> out = next;
                case "-alg" -> alg = next;
                default -> {
                    System.out.println("Not valid arguments");
                    System.exit(0);
                }
            }
        }

        EncryptionDecryptionMachine machine = new EncryptionDecryptionMachine(mode, key, data, in, out, alg);
        machine.run();
    }

    public static boolean areArgumentsValid(String[] args) {
        for(int i = 0; i < args.length; i += 2) {
            if(args[i].charAt(0) != '-') {
                return false;
            }
        }
        return true;
    }
}