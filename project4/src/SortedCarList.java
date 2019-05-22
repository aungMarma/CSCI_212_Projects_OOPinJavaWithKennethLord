public class SortedCarList extends CarList {

    /**
     * Constructor
     */
    public SortedCarList() {
        // Call super constructor
        super();
    }

    /**
     * Insert CarNode in sorted order
     */
    public void add(CarNode carNode) {
        // Find a two nodes (curr and curr.next) to insert between
        CarNode curr = first;
        while (curr.next != null && carNode.data.compareTo(curr.next.data) > 0) {
            curr = curr.next;
        }
        // Insert carNode to the list
        carNode.next = curr.next;
        curr.next = carNode;
        // Edge case, inserted carNode at the end
        if (last == curr) {
            last = carNode;
        }
        // Increment the length
        length++;
    }
}