package FileData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Data {
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

    public static ArrayList<String> dataChunkToArrayList(String chunkData){
        return new ArrayList<String>(Arrays.asList(chunkData.split(" ")));
    }
}
