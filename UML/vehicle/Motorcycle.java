package vehicle;
public class Motorcycle extends Vehicle {
    private boolean hasHelmet;
    protected boolean isSportBike;

    public static int count = 0;

    public Motorcycle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle has started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle has stopped");
    }

    public void start(String model){
        System.out.println("Motorcycle of model: " + model + " has started");
    }

    public void stop(int year) {
        System.out.println("The " + year + " motorcycle has stopped");
    }
}
