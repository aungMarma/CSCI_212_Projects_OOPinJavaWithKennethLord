public class UnsortedCarList extends CarList {

    // Constructor
    public UnsortedCarList() {
        // Call super constructor
        super();
    }

    // Implement add
    public void add(CarNode carNode) {
        append(carNode);
    }
}