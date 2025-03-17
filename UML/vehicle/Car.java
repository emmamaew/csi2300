package vehicle;
public class Car extends Vehicle {
    private String engineType;
    protected int passengers;

    public static int count = 0;
    
    public Car(String model, int year) {
    this.model = model;
    this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Car has started");
    }

    @Override
    public void stop() {
        System.out.println("Car has stopped");
    }

    public void start(String model){
        System.out.println("Car of model: " + model + " has started");
    }

    public void stop(int year) {
        System.out.println("The " + year + " car has stopped");
    }
}

