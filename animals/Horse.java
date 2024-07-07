package animals;

public class Horse extends Animal{

    public Horse(String name, int age) {
        super(name, age, "horse");
        this.commands.add("carry");
        this.commands.add("ride");
        this.commands.add("neigh");
    }

}
