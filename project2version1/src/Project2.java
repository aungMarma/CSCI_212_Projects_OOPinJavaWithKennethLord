import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Project2 {

    public static void main(String[] args) {

        SortedCarList sortedCarList = new SortedCarList();
        UnsortedCarList unsortedCarList = new UnsortedCarList();
        fillLinkedList(args[0], unsortedCarList);
        fillLinkedList(args[0], sortedCarList);

        // Instantiate CarGui and display two arrays on it
        CarGUI carGui = new CarGUI(sortedCarList, unsortedCarList);
        carGui.startCarGui();
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
                int year = Integer.parseInt(carInfo.get(2));
                int mileage = Integer.parseInt(carInfo.get(3));
                Car car = new Car(make, model, year, mileage);
                CarNode carNode = new CarNode(car);
                carlist.add(carNode); // Magic of polymorphism
            } else { // If there are not four tokens
                if (carInfo.size() <= 3) {
                    System.out.println("not enough tokens");
                } else {
                    System.out.println("more than 4 tokens");
                }
            }
        }
        // Close the reader
        scannedFile.close();
    }
}
