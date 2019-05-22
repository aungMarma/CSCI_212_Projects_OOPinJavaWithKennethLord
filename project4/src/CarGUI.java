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
import java.awt.ScrollPane;

class CarGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea sortedTextArea;
    private JTextArea unsortedTextArea;

    private UnsortedCarList unsortedCarList;
    private SortedCarList sortedCarList;
    private SortedCarList searchedCarList;

    // Default constructor
    public CarGUI() {
        this("No title");
    }

    // A single parameter constructor, call setGui, init two carlists
    public CarGUI(String title) {
        super(title);
        this.setGUI();
        // init, so ready to add CarNode
        this.unsortedCarList = new UnsortedCarList();
        this.sortedCarList = new SortedCarList();
    }

    // Set GUI, one menubar with two menus
    public void setGUI() {
        // Configure the JFrame components we inherited
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400); // width, height
        this.setLocation(200, 200); // x, y of the window

        // JMenuBar
        JMenuBar jMenuBar = new JMenuBar();

        // Set filemenu on menubar
        JMenu fileMenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        FileMenuHandler fmh = new FileMenuHandler(this);
        open.addActionListener(fmh);
        quit.addActionListener(fmh);
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);
        jMenuBar.add(fileMenu);

        // Set editmenu on menubar
        JMenuItem search = new JMenuItem("Search");
        JMenu editMenu = new JMenu("Edit");
        EditMenuHandler editMenuHandler = new EditMenuHandler(this);
        search.addActionListener(editMenuHandler);
        editMenu.add(search);
        jMenuBar.add(editMenu);

        this.setJMenuBar(jMenuBar);
        this.setVisible(true);
    }

    // Set layout with two textareas
    public void setLayoutWithTwoTextAreas() {
        this.setLayout(new GridLayout(1, 2));
        this.unsortedTextArea = new JTextArea("Unsorted Cars:\n");
        this.sortedTextArea = new JTextArea("Sorted Cars:\n");

        JScrollPane scrollPaneEast = new JScrollPane(this.unsortedTextArea);
        JScrollPane scrollPaneWest = new JScrollPane(this.sortedTextArea);
        this.getContentPane().add(scrollPaneEast, BorderLayout.EAST);
        this.getContentPane().add(scrollPaneWest, BorderLayout.WEST);
    }

    // Given a Car's make create a SortedLinkeList
    public void searchCarMake(String carMake) {
        // Do nothing, nothing to search for
        if (this.sortedCarList.length == 0) {
            return;
        }
        this.searchedCarList = new SortedCarList();
        CarNode carNode = sortedCarList.first.next;
        while (carNode != null) {
            if (carMake.equals(carNode.data.getMake())) {
                CarNode cn = new CarNode(carNode.getData());
                searchedCarList.add(cn);
            }
            carNode = carNode.next;
        }
        // Update GUI textarea to show search result if there is at least one result
        this.updateTextAreas();
    }

    // Show textareas
    public void showTextAreas() {
        this.unsortedTextArea.append(this.unsortedCarList.toString());
        this.sortedTextArea.append(this.sortedCarList.toString());
        this.pack(); // resize if needed
    }

    // Update textareas to show only search result
    public void updateTextAreas() {
        this.unsortedTextArea.setText(null);
        this.sortedTextArea.setText(null);

        if (this.searchedCarList.length > 0) {
            this.unsortedTextArea.append(this.searchedCarList.toString());
        } else {
            this.unsortedTextArea.append("No match found!");
        }
    }

    // Read a file, store data in two linked lists
    public void readFile(File file) {
        FileReader readfile = null;
        Scanner scannedFile = null;
        try {
            readfile = new FileReader(file); // Can throw FileNotFoundException
            scannedFile = new Scanner(readfile); // Put the cursor at begnning of the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        String line = null;
        while (scannedFile.hasNextLine()) {
            line = scannedFile.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> carInfo = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                carInfo.add(token);
            }
            // Transform car info to Car -> CarNode -> CarList
            if (carInfo.size() == 4) {
                String make = carInfo.get(0);
                String model = carInfo.get(1);
                int year = toNumber(carInfo.get(2));
                int mileage = toNumber(carInfo.get(3));
                Car car = new Car(make, model, year, mileage);
                Car car1 = new Car(make, model, year, mileage);
                CarNode carNode = new CarNode(car);
                CarNode carNodeWHAT = new CarNode(car1);
                // add to lists
                this.unsortedCarList.add(carNode);
                this.sortedCarList.add(carNodeWHAT);
            } else { // If there are not four tokens
                if (carInfo.size() <= 3) {
                    System.out.println("Not enough tokens");
                } else {
                    System.out.println("Wrong format tokens");
                }
            }
        }

        // Close scanner, set layout and show textareas
        scannedFile.close();
        this.setLayoutWithTwoTextAreas();
        this.showTextAreas();
    }

    // A helper function for validation
    private static int toNumber(String inputNumString) {
        try {
            return Integer.parseInt(inputNumString);
        } catch (NumberFormatException e) {
            return 0;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return 0;
        }
    }
}