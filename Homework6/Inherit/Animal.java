public class Animal {
    
    public int age;
    public String gender;

    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    //method for isMammal()
    public void isMammal() {
        System.out.println("This is method isMammal() from the Animal class");
    }

    //method for mate()
    public void mate() {
        System.out.println("This is the mate() method from Animal class");
    }

public static void main(String[] args) {
    Animal myAnimal = new Animal(12, "Male");
    myAnimal.isMammal();
    myAnimal.mate();

    Fish myFish = new Fish(1, "Female", 6);
    myFish.isMammal();
    myFish.mate();

    Zebra myZebra = new Zebra(15, "Male", true);
    myZebra.isMammal();
    myZebra.mate();
    myZebra.run();
}


    }