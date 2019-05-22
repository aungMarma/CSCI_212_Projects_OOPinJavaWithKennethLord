import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

public class CarGUI extends JFrame {
    private JTextArea unsorted, sorted;
    private CarList carlist1, carlist2;

    public CarGUI(CarList carlist1, CarList carlist2) {
        super("CarGUI");
        this.carlist1 = carlist1;
        this.carlist2 = carlist2;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1, 2));

    }

    public void startCarGui() {
        this.setVisible(true);
        unsorted = new JTextArea();
        sorted = new JTextArea();
        CarNode currentNode1 = carlist1.first.next;
        while (currentNode1 != null) {
            String st = currentNode1.data.toString();
            unsorted.append(st + "\n");
            currentNode1 = currentNode1.next;
        }
        add(unsorted);

        CarNode currentNode2 = carlist2.first.next;
        while (currentNode2 != null) {
            String st = currentNode2.data.toString();
            unsorted.append(st + "\n");
            currentNode2 = currentNode2.next;
        }
        add(sorted);

    }
}