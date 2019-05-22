public class SortedCarList extends CarList {

    // Constructor
    public SortedCarList() {
        // Call super constructor
        super();
    }

    // Add in sorted order, my version
    public void insertSorted(CarNode carNode) {
        if (length == 0) {
            prepend(carNode);
        } else if (first.next.data.compareTo(carNode.data) >= 0) {
            prepend(carNode);
        } else if (last.data.compareTo(carNode.data) <= 0) {
            append(carNode);
        } else {
            // Find a place to insert
            CarNode curr = first.next;
            CarNode prev = curr;
            while (curr != last && curr.data.compareTo(carNode.data) <= 0) {
                prev = curr;
                curr = curr.next;
            }
            // Insert middle of two CarNodes
            carNode.next = curr;
            prev.next = carNode;
            length++;
        }
    }

    // Add CarNode sorted
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