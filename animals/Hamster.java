package animals;

public class Hamster extends Animal{

    public Hamster(String name, int age) {
        super(name, age, "hamster");
        this.commands.add("roll");
        this.commands.add("тапать");
    }

}
