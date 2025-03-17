package person;
public class Driver extends Person {
    private String licenseNumber;
    protected int experienceYears;

    public Driver(String name, int age) {
    this.name = name;
    this.age = age;
    }

    public void drive() {
        System.out.println("Is driving");
    }

    @Override
    public void greet() {
        System.out.println("driver has been greeted");
    }

    public void greet(String name){
        System.out.println("Driver, " + name + " has been greeted");
    }
}
