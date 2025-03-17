package fuel;
public class Fuel implements Refuelable {
    String type;
    int quantity;

    private String fuelType;
    protected int tankSize;

    @Override 
    public void refuel() {
        System.out.println("Vehicle is refueled");
    }
    public void refuel(int quantity) {
        System.out.println("Vehicle is refueled with " + quantity + " gallons of gasoline");
    }
}
