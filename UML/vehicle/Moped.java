package vehicle;
public class Moped extends Vehicle {
    private boolean hasPassengerSeats;
    protected boolean isElectric;

    public static int count = 0;
    
    public Moped(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Moped has started");
    }

    @Override
    public void stop() {
        System.out.println("Moped has stopped");
    }

    public void start(String model){
        System.out.println("Moped of model: " + model + " has started");
    }

    public void stop(int year) {
        System.out.println("The " + year + " moped has stopped");
    }
}
