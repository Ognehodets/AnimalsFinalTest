package animals;

//придумать, как действия вписать. Сделать листом строк?  abstract
public class Animal {

    protected String name;
    protected int age;
    protected String type;

    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString() {
        return ("Name: " + name + ", age: " + age + ", type: " + type);
    }
}
