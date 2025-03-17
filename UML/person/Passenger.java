package person;
public class Passenger extends Person {
    private String seatPreference;
    protected boolean canDrive;

    public Passenger(String name, int age) {
    this.name = name;
    this.age = age;
    }

    @Override
    public void greet() {
        System.out.println("passenger has been greeted");
    }

    public void greet(String name){
        System.out.println("Passenger, " + name + " has been greeted");
    }
    
}
