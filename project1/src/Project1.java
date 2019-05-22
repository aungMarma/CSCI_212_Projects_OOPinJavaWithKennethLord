import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Project1 {

    public static void main(String[] args) {

        // Fill cars array of input
        Car[] carsArray = fillArray(args[0]);
        // Make another copy carsArray
        Car[] unsortedCarsArray = Arrays.copyOf(carsArray, carsArray.length);

        // Sort carsArray
        sortCarsArray(carsArray);

        // Instantiate CarGui and display two arrays on it
        CarGUI carGui = new CarGUI("Cars");
        carGui.displayTwoArrayOfObjects(unsortedCarsArray, carsArray);
    }

    /**
     * Sort cars array by the car's make in alphabetical or lexicographical order
     * Using selection sort algorithm in O(n^2) time
     */
    private static void sortCarsArray(Car[] carsArray) {
        if (carsArray.length == 0) {
            return;
        }
        // At each iteration, swap a[i] with the smallest from the unsorted part
        for (int i = 0; i < carsArray.length - 1; i++) {
            // Find the smallest occurence at
            int smallestAt = i;
            for (int j = i + 1; j < carsArray.length; j++) {
                // If carsArray[smallestAt] > carsArray[j]
                // Found a smaller one, so smallestAt = j
                if (carsArray[smallestAt].compareTo(carsArray[j]) > 0) {
                    smallestAt = j;
                }
            }
            // Swap
            Car temp = carsArray[i];
            carsArray[i] = carsArray[smallestAt];
            carsArray[smallestAt] = temp;
        }
    }

    /**
     * @return array of cars
     * @param file with car info
     */
    private static Car[] fillArray(String myFile) {
        FileReader readfile = null;
        Scanner scannedFile = null;
        try {
            readfile = new FileReader(myFile); // Can throw FileNotFoundException
            scannedFile = new Scanner(readfile); // Put the cursor at begnning of the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null; // there is no file to read from, so return null
        }

        // ArrayList to store all cars
        ArrayList<Car> carsArray = new ArrayList<>();
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
                carsArray.add(car);
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
        // Transform arraylist of cars into array of cars
        Car[] cars = new Car[carsArray.size()];
        return carsArray.toArray(cars);
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