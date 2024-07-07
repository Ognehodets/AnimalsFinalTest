package registry;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import animals.*;

public class Registry {

    // метод очистки консоли
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //метод для получения случайного имени
    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    public static void main(String[] args) {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Animal> animalRegistry = new ArrayList<>();
        // Cat cat = new Cat(getName(), random.nextInt(10));
        // System.out.println(cat);
        // cat.vewCommands();
        // cat.addCommand("nothing");
        // cat.vewCommands();
    }
}
