package Games;

import ConsoleColors.ConsoleColors;
import FileData.Data;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class Games {
    public static void noteGame(String[] args) throws FileNotFoundException {
        final String data = Data.getFileData(args[0]);

        final String noteVolume = Data.getDataChunk("NOTE_VOLUME", data).replace("\n", "  ");
        ArrayList<String> noteVolumeSplit = Data.dataChunkToArrayList(noteVolume);

        final String notePitch = Data.getDataChunk("NOTE_PITCH", data).replace("\n", "  ");
        ArrayList<String> notePitchSplit = Data.dataChunkToArrayList(notePitch);

        final String noteColor = Data.getDataChunk("NOTE_COLOR", data).replace("\n", " RE ");
        ArrayList<String> noteColorSplit = Data.dataChunkToArrayList(noteColor);

        final String songData = Data.getDataChunk("SONG_DATA", data);

        String totalData = new String();

        for (int i = 0; i < noteVolumeSplit.size(); i++) {
            totalData += new GetColor().returnColor(noteColorSplit, notePitchSplit, i);
        }

        totalData += ConsoleColors.RESET;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n" + songData + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(totalData);
    }
}

final class GetColor {
    public String returnColor(ArrayList<String> nc, ArrayList<String> tp, Integer i){
        return ConsoleColors.HEX_BRIGHT_ZS_C(nc.get(i), tp.get(i));
    }
}
