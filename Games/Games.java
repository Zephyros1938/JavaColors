package Games;

import ConsoleColors.ConsoleColors;
import FileData.Data;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class Games {
    public static void noteGame(String[] args) throws FileNotFoundException {
        String data = Data.getFileData(args[0]);

        String noteVolume = Data.getDataChunk("NOTE_VOLUME", data).replace("\n", "  ");
        ArrayList<String> noteVolumeSplit = Data.dataChunkToArrayList(noteVolume);

        String notePitch = Data.getDataChunk("NOTE_PITCH", data).replace("\n", "  ");
        ArrayList<String> notePitchSplit = Data.dataChunkToArrayList(notePitch);

        String noteColor = Data.getDataChunk("NOTE_COLOR", data).replace("\n", " RETURN ");
        ArrayList<String> noteColorSplit = Data.dataChunkToArrayList(noteColor);

        String songData = Data.getDataChunk("SONG_DATA", data);

        String totalData = new String();

        for (int i = 0; i < noteVolumeSplit.size(); i++) {
            totalData += ConsoleColors.HEX_BRIGHT_ZS(noteColorSplit.get(i), notePitchSplit.get(i));
        }

        totalData += ConsoleColors.RESET;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n" + songData + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(totalData);
    }
}
