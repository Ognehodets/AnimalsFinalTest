package animals;

import java.util.ArrayList;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age, "cat");
        this.commands.add("mew");
        this.commands.add("lie");
        
    }
    
}
