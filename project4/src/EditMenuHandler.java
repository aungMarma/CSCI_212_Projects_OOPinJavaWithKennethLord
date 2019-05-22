import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuHandler implements ActionListener {
    private CarGUI gui;

    public EditMenuHandler(CarGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Search")) {
            String input = JOptionPane.showInputDialog(null, "Enter a Car make");
            this.gui.searchCarMake(input);
        }
    }
}