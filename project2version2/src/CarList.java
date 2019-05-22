// A singlylinkedlist of carnodes
abstract class CarList {
    protected CarNode first;
    protected CarNode last;

    // Need access from subclass SortedCarList
    // Since SortedCarList has own implementation of append, adding a node to the
    // list
    // thus increasing the length of the list
    protected int length;

    public CarList() {
        Car dummyCar = new Car("nobody", "none", -1, -1);
        last = first = new CarNode(dummyCar);
        length = 0;
    }

    // For the magic of polymorphism
    public abstract void add(CarNode carNode);

    // add CarNode to the end of the list
    public void append(CarNode carNode) {
        last.next = carNode;
        last = carNode;
        length++;
    }

    // add CarNode to the beginning of the list
    public void prepend(CarNode carNode) {
        carNode.next = first.next;
        first.next = carNode;

        // If the last way empty
        if (first == last) {
            last = carNode;
        }
        length++;
    }

    /**
     * @return String representation of elements in linked list
     */
    public String toString() {
        CarNode carNode = first.next;
        String returnString = "";
        while (carNode != null) {
            // carNode.data is Car
            returnString += carNode.data.toString() + "\n";
            carNode = carNode.next;
        }
        return returnString;
    }
}
