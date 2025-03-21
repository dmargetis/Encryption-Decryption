
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.PrintWriter;

public class EncryptionDecryptionMachine {
    private final String mode;
    private final int key;
    private final String data;
    private final String in;
    private final String out;
    private final String alg;
    private String result = "";

    public EncryptionDecryptionMachine(String mode, int key, String data, String in, String out, String alg) {
        this.mode = mode;
        this.key = key;
        this.data = data;
        this.in = in;
        this.out = out;
        this.alg = alg;
    }

    public void run() {
        String dataToProcess = !data.isEmpty() ? data : !in.isEmpty() ? readFromFile(in) : "";

        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        Algorithm algorithm = algorithmFactory.getAlgorithm(alg);

        switch(mode) {
            case "enc" -> result = algorithm.encrypt(dataToProcess, key);
            case "dec" -> result = algorithm.decrypt(dataToProcess, key);
            default -> System.out.println("Not valid option");
        }

        if (out.isEmpty()){
            System.out.println(result);
        }
        else {
            writeToFile(out);
        }
    }

    public String readFromFile(String fileName) {
        String fileData = "";
        Path filePath = Paths.get(String.format( ".\\data\\%s", fileName));
        try {
            fileData = Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        return fileData;
    }

    public void writeToFile(String fileName) {
        File file = new File(String.format(".\\data\\%s", fileName));

        try(PrintWriter writer = new PrintWriter(file)) {
            writer.print(result);
            if (writer.checkError()) {
                System.err.println("An error occured while writing the file");
            } else {
                System.out.println("Data written to file successfully.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error File not found: " + e.getMessage());
        }
    }
}
