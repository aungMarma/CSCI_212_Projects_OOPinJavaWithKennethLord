
/*
* This program asks user to enter a sentence
* and show the user how many times E and e occur in that sentence
* if user enters stop(not case sensitive), it terminates.
* Name: Aungkyawcha Marma Lab: (54641)
*/
import javax.swing.JOptionPane; // for Pane

public class Project0 {
    public static void main(String[] args) {

        // A string var to hold user input
        String inputSentence;

        // To keep asking user to enter a sentence
        while (true) {

            // Ask user to enter a sentence
            inputSentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");

            // If user entered stop as a sentence, terminate the program
            if (inputSentence.equalsIgnoreCase("stop")) {
                System.exit(1); // exit the program
            }

            // Count E and e occurrencs on user's entered sentence
            int lowerEcount = 0, upperEcount = 0;
            for (int i = 0; i < inputSentence.length(); i++) {
                if (inputSentence.charAt(i) == 'E') {
                    upperEcount++;
                } else if (inputSentence.charAt(i) == 'e') {
                    lowerEcount++;
                }
            }

            // message for the user
            String messageForLowerE = "Number of lower case e's: " + lowerEcount;
            String messageForUpperE = "Number of upper case e's: " + upperEcount;
            String wholeMessage = messageForLowerE + "\n" + messageForUpperE;

            // Show user occurrences of E and e
            JOptionPane.showMessageDialog(null, wholeMessage);
        }
    }
}
