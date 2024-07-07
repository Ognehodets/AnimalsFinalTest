package animals;

import java.util.ArrayList;

public abstract class Animal {

    protected String name;
    protected int age;
    protected String type;
    protected ArrayList<String> commands = new ArrayList<>();

    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
        return ("Name: " + name + ", age: " + age + ", type: " + type);
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    public void vewCommands() {
        StringBuilder sbCommands = new StringBuilder();
        for (String command : commands) {
            sbCommands.append(command.toString());
            sbCommands.append('\t');
        }
        System.out.println(sbCommands);
    }
}
