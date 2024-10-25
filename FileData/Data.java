package FileData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
    private static File getFile(String fileName) throws FileNotFoundException {
        return new File(fileName);
    }

    public static String getFileData(String fileName) throws FileNotFoundException {
        String fileData = new String();
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNextLine()) {
            fileData += scanner.nextLine() + "\n";
        }

        scanner.close();

        return fileData;
    }

    public static String getDataChunk(String delimiter, String data) {
        String END_DELIMITER = "END_" + delimiter;
        String START_DELIMITER = "START_" + delimiter;
        return data.substring(data.indexOf(START_DELIMITER) + START_DELIMITER.length() + 1,
                data.indexOf(END_DELIMITER) - 1);
    }
}
