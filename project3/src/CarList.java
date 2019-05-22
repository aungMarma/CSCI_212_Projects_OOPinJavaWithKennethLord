/**
 * A singlylinkedlist Start at first.next, end at last Node is CarNode
 */
abstract class CarList {

    /**
     * protected instances variable Protected, inorder to increment it from subclass
     */
    protected CarNode first;
    protected CarNode last;
    protected int length;

    /**
     * 
     */
    public CarList() {
        Car dummyCar = new Car("nobody", "none", -1, -1);
        last = first = new CarNode(dummyCar);
        length = 0;
    }

    // For the magic of polymorphism
    public abstract void add(CarNode carNode);

    /**
     * Append a CarNode
     * 
     * @param carNode
     */
    public void append(CarNode carNode) {
        last.next = carNode;
        last = carNode;
        length++;
    }

    /**
     * Prepend a CarNode
     * 
     * @param carNode
     */
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
