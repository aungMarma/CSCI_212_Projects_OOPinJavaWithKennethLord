import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

class CarGUI extends JFrame {
    // Private instance variables
    private JScrollPane scrollPaneEast;
    private JScrollPane scrollPaneWest;
    private JTextArea sortedArrayTextArea;
    private JTextArea unsorteArrayTextArea;

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

        // Configure the JFrame components we inherited
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100); // width, height
        this.setLocation(200, 200); // x, y of the window

        // set the layout, One row and two colums
        this.setLayout(new GridLayout(1, 2));

        // Initialize JTextArea
        this.unsorteArrayTextArea = new JTextArea("Unsorted Cars:\n");
        this.sortedArrayTextArea = new JTextArea("Sorted Cars:\n");

        // Initialize JScrollPane
        this.scrollPaneEast = new JScrollPane(this.unsorteArrayTextArea);
        this.scrollPaneWest = new JScrollPane(this.sortedArrayTextArea);

        // Add scroll panes to the content pane
        this.getContentPane().add(this.scrollPaneEast, BorderLayout.EAST);
        this.getContentPane().add(this.scrollPaneWest, BorderLayout.WEST);
    }

    /**
     * Display two array of cars
     */
    public void displayTwoArrayOfObjects(Car[] unsortedArray, Car[] sortedArray) {
        // Display GUI
        showGui();

        // Get string representations of cars array
        String unsortedString = getCarsArrayString(unsortedArray);
        String sortedString = getCarsArrayString(sortedArray);

        // Append to TextArea
        this.unsorteArrayTextArea.append(unsortedString);
        this.sortedArrayTextArea.append(sortedString);
    }

    /**
     * Make GUI visible
     */
    public void showGui() {
        this.pack();
        this.setVisible(true);
    }

    /**
     * @param array of Car objects
     * @return string representation of car's array
     */
    private String getCarsArrayString(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.length; i++) {
            sb.append(cars[i].toString() + "\n");
        }
        return sb.toString();
    }
}