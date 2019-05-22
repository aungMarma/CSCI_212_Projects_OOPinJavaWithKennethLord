abstract class CarList {
    protected CarNode first;
    protected CarNode last;

    protected int length;

    public CarList() {
        this.first = new CarNode(new Car("Dummy Car", "I made", -1, -1));
        this.last = this.first;
        this.length = 0;
    }

    public void append(CarNode newCarNode) {
        this.last.next = newCarNode;
        this.last = newCarNode;

        this.length++;
    }

    // dynamic method binding
    public abstract void add(CarNode carNode);
}
