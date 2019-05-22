import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Project3 {

    public static void main(String[] args) {

        if (args.length == 1) {
            SortedCarList sortedCarList = new SortedCarList();
            UnsortedCarList unsortedCarList = new UnsortedCarList();
            fillLinkedList(args[0], unsortedCarList);
            fillLinkedList(args[0], sortedCarList);
            // printLinkedList(sortedCarList);
            // printLinkedList(unsortedCarList);
            CarGUI carGui = new CarGUI("Cars");
            // without menubar
            carGui.twoLinkedListsToDisplay(unsortedCarList, sortedCarList);
        } else {
            // Instantiate CarGui, open a file, read the file and display
            CarGUI carGui = new CarGUI("Cars");
            carGui.showGuiWithMenuBar();
        }
    }

    // Visualize linkedlist
    public static void printLinkedList(CarList ls) {
        CarNode curr = ls.first.next;
        while (curr != null) {
            System.out.print(curr.data.toString() + "->");
            curr = curr.next;
        }
        System.out.print("null\"");
    }

    // fill carlist with myfile data
    public static void fillLinkedList(String myFile, CarList carlist) {
        FileReader readfile = null;
        Scanner scannedFile = null;
        try {
            readfile = new FileReader(myFile); // Can throw FileNotFoundException
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
                carlist.add(carNode); // Magic of polymorphism
            } else { // If there are not four tokens
                if (carInfo.size() <= 3) {
                    System.out.println(line + ": not enough tokens");
                } else {
                    System.out.println(line + ": more than 4 tokens");
                }
            }
        }
        // Close the reader
        scannedFile.close();
    }

    /**
     * Check if input string is a number if so, return that, if not, return 0
     * 
     * @param input string to parse as int
     * @return int version of the input string
     */
    public static int toNumber(String inputNumString) {
        try {
            return Integer.parseInt(inputNumString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}