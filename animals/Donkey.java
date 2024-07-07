package animals;

public class Donkey extends Animal{

    public Donkey(String name, int age) {
        super(name, age, "donkey");
        this.commands.add("carry");
        this.commands.add("ride");
    }

}
