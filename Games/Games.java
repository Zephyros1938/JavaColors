package Games;

import ConsoleColors.ConsoleColors;
import FileData.Data;
import java.io.FileNotFoundException;

public class Games {
    public static void noteGame(String[] args) throws FileNotFoundException {
        String data = Data.getFileData(args[0]);

        String noteData = Data.getDataChunk("NOTE_DATA", data).replace("\n", " ");
        String colorData = Data.getDataChunk("COLOR_DATA", data).replace("\n", " ");

        String songData = Data.getDataChunk("SONG_DATA", data);

        String[] noteDataSplit = noteData.replace("\n", " ").split(" ");
        String[] colorDataSplit = colorData.split(" ");

        String totalData = new String();

        for (int i = 0; i < noteDataSplit.length; i++) {
            totalData += ConsoleColors.HEX_BRIGHT_ZS(colorDataSplit[i], noteDataSplit[i]);
        }
        totalData += ConsoleColors.RESET;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n" + songData + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(totalData);
    }
}
