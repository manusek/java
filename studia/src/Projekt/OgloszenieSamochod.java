package Projekt;

public class OgloszenieSamochod extends Ogloszenie{
    private int yearOfProduction;

    private int carMileage;

    public OgloszenieSamochod(){};

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }
}
