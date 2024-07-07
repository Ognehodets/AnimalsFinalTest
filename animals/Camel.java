package animals;

public class Camel extends Animal{

    public Camel(String name, int age) {
        super(name, age, "camel");
        this.commands.add("spit");
        this.commands.add("carry");
        this.commands.add("ride");
    }

}
