public class Fish extends Animal {
    private int sizeInFeet;

    public Fish(int age, String gender, int sizeInFeet) {
        super(age, gender);
        this.sizeInFeet = sizeInFeet;
    }

    private void canEat() {
        System.out.println("This is the private mathod canEat() from Fish class.");
    }
    public void feed() {
        canEat();
    }

    }
