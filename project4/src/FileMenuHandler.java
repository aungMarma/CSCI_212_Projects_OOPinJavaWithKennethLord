import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileMenuHandler implements ActionListener {
    private CarGUI gui;

    public FileMenuHandler(CarGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Get the command name from the event
        String menuName = event.getActionCommand();

        if (menuName.equals("Open")) {
            JFileChooser fc = new JFileChooser();

            // Attempt to open the file
            int returnVal = fc.showOpenDialog(null);
            // If user selected a file, create File object and pass it to
            // the gui's readFile method
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                this.gui.readFile(file);
            } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                System.out.println("Open command cancelled by user.");
            }
        } else if (menuName.equals("Quit")) {
            System.exit(1);
        }
    }
}