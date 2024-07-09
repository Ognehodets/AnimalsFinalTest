package registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import animals.*;

public class Registry {

    // метод очистки консоли
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // метод для получения случайного имени
    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    private static Animal creatRandomAnimal() {
        Random random = new Random();
        int typeCharacter = random.nextInt(6);
        switch (typeCharacter) {
            case 0:
                return new Cat(getName(), random.nextInt(1, 10));
            case 1:
                return new Dog(getName(), random.nextInt(1, 12));
            case 2:
                return new Hamster(getName(), random.nextInt(1, 6));
            case 3:
                return new Donkey(getName(), random.nextInt(1, 15));
            case 4:
                return new Camel(getName(), random.nextInt(1, 15));
            case 5:
                return new Horse(getName(), random.nextInt(1, 18));
            default:
                return null;
        }
    }

    private static void printAnimals(ArrayList<Animal> listToPrint) {
        for (int i = 0; i < listToPrint.size(); i++) {
            System.out.println(Integer.toString(i + 1) + " " + listToPrint.get(i));
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Animal> animalRegistry = new ArrayList<>();
        int listSize = random.nextInt(1, 10);
        // создание случайного списка зверей
        for (int i = 0; i < listSize; i++) {
            animalRegistry.add(creatRandomAnimal());
        }

        String choice = "";
        clearConsole();
        while (!choice.equals("7")) {
            System.out.println("Choose your action: \n" +
                    "1. View all list of animals.\n" +
                    "2. Add animal.\n" +
                    "3. View animal's commands.\n" +
                    "4. Add command to animal.\n" +
                    "5. Count animals.\n" +
                    "6. Sort animals by age.\n" +
                    "7. Exit.");
            choice = scanner.next();
            switch (choice) {
                case "1":
                    printAnimals(animalRegistry);
                    break;

                case "2":
                    System.out.println("Enter the name of your animal: ");
                    String name = scanner.next();
                    int age = 0;
                    boolean isValidInput = false;
                    do {
                        System.out.println("Enter age of your animal:");
                        if (scanner.hasNextInt()) {
                            age = scanner.nextInt();
                            isValidInput = true;
                        } else {
                            System.out.println("Age must be an integer.");
                            scanner.next();
                        }
                    } while (!isValidInput);
                    String type = "";
                    isValidInput = false;
                    do {
                        System.out.println("Choose the type of your animal:\n" +
                                "1. Cat.\n" +
                                "2. Dog.\n" +
                                "3. Hamster.\n" +
                                "4. Donkey.\n" +
                                "5. Camel.\n" +
                                "6. Horse.");
                        type = scanner.next();
                        switch (type) {
                            case "1":
                                animalRegistry.add(new Cat(name, age));
                                isValidInput = true;
                                break;
                            case "2":
                                animalRegistry.add(new Dog(name, age));
                                isValidInput = true;
                                break;
                            case "3":
                                animalRegistry.add(new Hamster(name, age));
                                isValidInput = true;
                                break;
                            case "4":
                                animalRegistry.add(new Donkey(name, age));
                                isValidInput = true;
                                break;
                            case "5":
                                animalRegistry.add(new Camel(name, age));
                                isValidInput = true;
                                break;
                            case "6":
                                animalRegistry.add(new Horse(name, age));
                                isValidInput = true;
                                break;
                            default:
                                break;
                        }
                    } while (!isValidInput);
                    break;

                case "3":
                    String numOfAnimalToShow = "";
                    Set<String> setNumbers = new HashSet<>();
                    for (int i = 1; i < animalRegistry.size() + 1; i++) {
                        setNumbers.add(Integer.toString(i));
                    }
                    do {
                        System.out.println("Select number of animal from 1 to " + animalRegistry.size());
                        numOfAnimalToShow = scanner.next();
                    } while (!setNumbers.contains(numOfAnimalToShow));
                    animalRegistry.get(Integer.parseInt(numOfAnimalToShow) - 1).viewCommands();
                    break;

                case "4":
                    String numOfAnimalToChange = "";
                    Set<String> otherSetNumbers = new HashSet<>();
                    for (int i = 1; i < animalRegistry.size() + 1; i++) {
                        otherSetNumbers.add(Integer.toString(i));
                    }
                    do {
                        System.out.println("Select number of animal from 1 to " + animalRegistry.size());
                        numOfAnimalToChange = scanner.next();
                    } while (!otherSetNumbers.contains(numOfAnimalToChange));
                    String newCommand = scanner.next();
                    animalRegistry.get(Integer.parseInt(numOfAnimalToChange) - 1).addCommand(newCommand);
                    break;

                case "5":
                    System.out.println("Total number of animals is " + animalRegistry.size());
                    break;

                case "6":
                    ArrayList<Animal> sortedList = new ArrayList<>();
                    sortedList.addAll(animalRegistry);
                    sortedList.sort(new Comparator<Animal>() {
                        @Override
                        public int compare(Animal animal1, Animal animal2) {
                            return animal2.age - animal1.age;
                        }
                    });
                    printAnimals(sortedList);
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}
