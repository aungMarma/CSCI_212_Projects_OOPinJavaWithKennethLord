public class CarNode {
    protected Car data;
    protected CarNode next;

    /**
     * Constructor
     * 
     * @param c, a car object
     */
    public CarNode(Car c) {
        data = c;
        next = null;
    }

    /**
     * Compare make to given car's make (CarNode data refers to a Car) If make is
     * greater than given car's make, return positive int Else 0 for equal and
     * negative int if make is lesser than given car's make
     * 
     * @return int
     */
    public int compareTo(CarNode carNode) {
        return data.getMake().compareTo(carNode.data.getMake());
    }
}
