package vehicle;
public class Truck extends Vehicle {
    private String loadCapacity;
    public final int wheels = 6;

    public static int count = 0;

    public Truck(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Truck has started");
    }

    @Override
    public void stop() {
        System.out.println("Truck has stopped");
    }

    public void start(String model){
        System.out.println("Truck of model: " + model + " has started");
    }

    public void stop(int year) {
        System.out.println("The " + year + " truck has stopped");
    }

}
