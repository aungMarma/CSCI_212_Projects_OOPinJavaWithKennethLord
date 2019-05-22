public class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;

    public Car(String make, String model, int year, int mileage) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;

    }

    public String getMake() {
        return make;

    }

    public String getModel() {
        return model;

    }

    public int getYear() {
        return year;

    }

    public void setMake(String make) {

        this.make = make;

    }

    public void setModel(String model) {
        this.model = model;

    }

    public void setYear(int year) {
        this.year = year;

    }

    public int getMileage() {
        return mileage;

    }

    public void setMileage(int mileage) {
        this.mileage = mileage;

    }

    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", year=" + year + ", mileage=" + mileage + "]";

    }

    // I wrote this, this.make bigger > car.make return postion int
    public int compareTo(Car car) {
        return this.make.compareTo(car.make);
    }
}
