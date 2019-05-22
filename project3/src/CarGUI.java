import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;

class CarGUI extends JFrame {
    // Private instance variables
    private JScrollPane scrollPaneEast;
    private JScrollPane scrollPaneWest;
    private JTextArea sortedTextArea;
    private JTextArea unsortedTextArea;

    private UnsortedCarList unsortedCarList;
    private SortedCarList sortedCarList;

    /**
     * Default constructor
     */
    public CarGUI() {
        this("No title");
    }

    /**
     * A single parameter constructor
     * 
     * @param title of GUI
     */
    public CarGUI(String title) {
        // Instantiate the super class variables
        super(title);

        // Set up GUI
        this.setGUI();
        // Two lists
        this.unsortedCarList = new UnsortedCarList();
        this.sortedCarList = new SortedCarList();
    }

    public void setLayoutWithTwoTextAreas() {
        // set the layout, One row and two colums
        this.setLayout(new GridLayout(1, 2));
        // Initialize JTextArea
        this.unsortedTextArea = new JTextArea("Unsorted Cars:\n");
        this.sortedTextArea = new JTextArea("Sorted Cars:\n");
        // Initialize JScrollPane
        this.scrollPaneEast = new JScrollPane(this.unsortedTextArea);
        this.scrollPaneWest = new JScrollPane(this.sortedTextArea);
        // Add scroll panes to the content pane
        this.getContentPane().add(this.scrollPaneEast, BorderLayout.EAST);
        this.getContentPane().add(this.scrollPaneWest, BorderLayout.WEST);
    }

    public void setGUI() {
        // Configure the JFrame components we inherited
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400); // width, height
        this.setLocation(400, 200); // x, y of the window
    }

    public void setFileMenuBar() {
        // menubar has filemenu, filemenu has menuitem 'Open' and 'Quit',
        // this a JFrame which has menubar

        // menu items
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        // menubar
        JMenuBar menuBar = new JMenuBar();
        // menu
        JMenu fileMenu = new JMenu("File");
        // menhandler, an ActionListener object
        FileMenuHandler fmh = new FileMenuHandler(this);

        // Add evet handler to open and quit
        open.addActionListener(fmh);
        quit.addActionListener(fmh);

        // Add the menu items to the file menu
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        // Add file menu to the menu bar, and set this gui's
        // menu bar to the menuBar we created above
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    /**
     * Display two lists of cars
     */
    public void twoLinkedListsToDisplay(UnsortedCarList unsortedCarList, SortedCarList sortedCarList) {
        this.sortedCarList = sortedCarList;
        this.unsortedCarList = unsortedCarList;
        this.showGuiWithoutMenuBar();
        this.showTextAreas(); // display in gui
    }

    /**
     * Make GUI visible
     */
    public void showGuiWithoutMenuBar() {
        this.pack();
        this.setVisible(true);
    }

    public void showGuiWithMenuBar() {
        this.setFileMenuBar();
        this.pack();
        this.setVisible(true);
    }

    public void showTextAreas() {
        // set tile of the colums of textarea with title
        this.setLayoutWithTwoTextAreas();
        // display read data
        this.unsortedTextArea.append(this.unsortedCarList.toString());
        this.sortedTextArea.append(this.sortedCarList.toString());
    }

    /**
     * Read carinfor from file Create two linked list out of data Append two
     * textareas
     * 
     * @param file
     */
    public void readFile(File file) {
        FileReader readfile = null;
        Scanner scannedFile = null;
        try {
            readfile = new FileReader(file); // Can throw FileNotFoundException
            scannedFile = new Scanner(readfile); // Put the cursor at begnning of the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return; // there is no file to read from, get out
        }

        // line for input line
        String line = null;
        while (scannedFile.hasNextLine()) {
            // Read a line
            line = scannedFile.nextLine();
            // Tokenize the line
            StringTokenizer tokenizer = new StringTokenizer(line, ",");

            // An arrlist to store a single car info
            ArrayList<String> carInfo = new ArrayList<>();

            // Store all tokens in carInfo arraylist
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                carInfo.add(token);
            }

            // There has to be four tokens in a line
            // If so, make a Car object of these tokens
            // Store the object in carArrays
            if (carInfo.size() == 4) {
                String make = carInfo.get(0);
                String model = carInfo.get(1);
                int year = toNumber(carInfo.get(2));
                int mileage = toNumber(carInfo.get(3));
                Car car = new Car(make, model, year, mileage);
                CarNode carNode = new CarNode(car);
                CarNode carNodeWHAT = new CarNode(car);

                // When I add same carNode to both linkedlist
                // the program just stall, keep running but doing nothing
                // WHY??
                this.unsortedCarList.add(carNode);
                this.sortedCarList.add(carNodeWHAT);
            } else { // If there are not four tokens
                if (carInfo.size() <= 3) {
                    System.out.println("'" + line + "'" + ": Not enough tokens");
                } else {
                    System.out.println("'" + line + "'" + ": Wrong format tokens");
                }
            }
        }
        // show text areas
        this.showTextAreas();
        // Close the reader
        scannedFile.close();
    }

    public int toNumber(String inputNumString) {
        try {
            return Integer.parseInt(inputNumString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}