import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JFrame.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ConsoleColors.*;
import FileData.*;
import Games.*;

import java.io.FileNotFoundException;

// useful escape code link: https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Games.noteGame(args);
    }
}