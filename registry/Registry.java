package registry;

import java.util.Random;
import animals.*;

public class Registry {

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Animal animal = new Animal(getName(), random.nextInt(10), "cat");
        System.out.println(animal);
    }
}
