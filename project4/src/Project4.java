import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Project4 {

    public static void main(String[] args) {
        CarGUI carGui = new CarGUI("Cars");
        carGui.setGUI();
    }
}

// Exception in thread"AWT-EventQueue-0" java.lang.NullPointerException
// at
// java.desktop/javax.swing.LayoutComparator.compare(LayoutComparator.java:117)
// at
// java.desktop/javax.swing.LayoutComparator.compare(LayoutComparator.java:42)