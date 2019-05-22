/**
 * A Car with make, model, year and mileage
 */

public class Car {

    // private instance variables
    private String make;
    private String model;
    private int year;
    private int mileage;

    /**
     * @param make    the make of the car
     * @param model   the model of the car
     * @param year    when the car is made
     * @param mileage mileage the car can afford
     */
    public Car(String make, String model, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param mileage the mileage to set
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * @return info of the car
     */
    @Override
    public String toString() {
        String carInfo = make + "," + model + "," + year + "," + mileage;
        return carInfo;
    }

    /**
     * Compare make to given car's make If make is greater than given car's make,
     * return positive int Else 0 for equal and negative int if make is lesser than
     * given car's make
     * 
     * @return int
     */
    public int compareTo(Car car) {
        return make.compareTo(car.make);
    }
}