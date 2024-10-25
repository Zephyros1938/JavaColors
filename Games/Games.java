package Games;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import ConsoleColors.ConsoleColors;
import FileData.Data;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    public static void noteGameJF(String[] args) throws FileNotFoundException {
        JFrame jFrame = new JFrame();

        jFrame.setTitle("Test Title");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setSize(400, 250);

        String data = Data.getFileData(args[0]);

        String noteData = Data.getDataChunk("NOTE_DATA", data);
        String colorData = Data.getDataChunk("COLOR_DATA", data);

        String[] jTableColorData = colorData.replace(" RETURN", "").split("\n");

        noteData = noteData.replace("\n", " ");
        colorData = colorData.replace("\n", " ");

        String songData = Data.getDataChunk("SONG_DATA", data);

        String[] noteDataSplit = noteData.split("");
        String[] colorDataSplit = colorData.split(" ");

        String totalData = new String();

        DefaultTableModel model = new DefaultTableModel();

        for(int x = 0; x < jTableColorData[0].split(" ").length; x++){
            model.addColumn(x);
        }
        for (int x = 0; x < jTableColorData.length; x++) {
            model.addRow(jTableColorData[x].split(" "));
        }

        JTable jTable = new JTable(model);

        jTable.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));

        for (int i = 0; i < noteDataSplit.length; i++) {
            // System.out.println("a " + colorDataSplit[i] + " a");
            totalData += ConsoleColors.HEX_BRIGHT_ZS(colorDataSplit[i], noteDataSplit[i]);
        }
        totalData += ConsoleColors.RESET;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=\n" + songData + "\n=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(totalData);

        jTable.setName("Note Table");

        jFrame.getContentPane().add(jTable);

        jFrame.setVisible(true);
    }

    public static void colorGame(JFrame jFrame) {
        jFrame.addKeyListener(new KeyAdapter() {

            public String keyCharacterBytes = new String();

            public Boolean settingColor = true;

            public void keyPressed(KeyEvent e) {
                final char keyCharacter = e.getKeyChar();

                switch (keyCharacter) {
                    case '`':
                        settingColor = !settingColor;
                    default:
                        break;
                }

                if (settingColor) {
                    switch (keyCharacter) {
                        case 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F', '1', '2', '3', '4', '5', '6',
                                '7', '8', '9', '0':
                            keyCharacterBytes += keyCharacter;
                            break;
                        default:
                            break;
                    }

                    if (keyCharacterBytes.length() > 5) {
                        final String rgbR = keyCharacterBytes.substring(0, 2);
                        final String rgbG = keyCharacterBytes.substring(2, 4);
                        final String rgbB = keyCharacterBytes.substring(4, 6);

                        final int hexR = Integer.parseInt(rgbR, 16);
                        final int hexG = Integer.parseInt(rgbG, 16);
                        final int hexB = Integer.parseInt(rgbB, 16);

                        System.out.println(ConsoleColors.RGB_BRIGHT(hexR, hexG, hexB) + keyCharacterBytes);

                        keyCharacterBytes = new String();
                    }
                } else {
                    switch (keyCharacter) {
                        case '\n':
                            System.out.print("\n");
                            break;
                        case '\b':
                            System.out.print("\b \b");
                            break;
                        case '\t':
                            System.out.print('\t');
                            break;
                        case '`':
                            break;
                        default:
                            System.out.print(keyCharacter);
                            break;
                    }
                }
            }
        });
    }
}
