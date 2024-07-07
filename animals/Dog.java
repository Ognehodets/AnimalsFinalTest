package animals;

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age,"dog");
        this.commands.add("bark");
        this.commands.add("sit");
    }
    
}
