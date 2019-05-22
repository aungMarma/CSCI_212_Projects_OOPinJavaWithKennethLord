public class SortedCarList extends CarList {

    public SortedCarList() {
        super();
    }

    public void add(CarNode carNode) {
        // CarNode carNode = new CarNode(b);
        // Sercedeze
        CarNode curreCarNode = first;

        // Dummy, Honda, Toytota, Tesla, YOUSHKH
        // ^
        // YOUSHKH
        while (curreCarNode.next != null && carNode.data.getMake().compareTo(curreCarNode.next.data.getMake()) >= 0) {
            curreCarNode = curreCarNode.next;
        }
        carNode.next = curreCarNode.next;
        curreCarNode.next = carNode;

        if (last == curreCarNode) {
            last = carNode;
        }
    }
}

/*
 * if (head == null) {
 * 
 * super.append(b);
 * 
 * } else {
 * 
 * CarNode node = new CarNode(b);
 * 
 * CarNode b1 = head, b2 = head.next;
 * 
 * while (b1 != null) {
 * 
 * if (b2 == null) {
 * 
 * if (b1 == head) {
 * 
 * if (b.volume() < head.car.volume()) {
 * 
 * node.next = head;
 * 
 * head = node;
 * 
 * break;
 * 
 * }
 * 
 * }
 * 
 * b1.next = node;
 * 
 * break;
 * 
 * }
 * 
 * if (b.volume() >= b1.car.volume()
 * 
 * && b.volume() <= b2.car.volume()) {
 * 
 * node.next = b2;
 * 
 * b1.next = node;
 * 
 * break;
 * 
 * } b1 = b2;
 * 
 * b2 = b1.next;
 * 
 * }
 * 
 * }
 * 
 * }
 */

// }