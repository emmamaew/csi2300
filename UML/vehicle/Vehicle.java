package vehicle;
abstract class Vehicle {
    String model;
    int year;
    public static int count = 0;

    public abstract void start();
    public abstract void stop();
}