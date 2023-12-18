import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal {

    public static int totalAnimals = 0;
    protected int id;
    private String name;
    private LocalDate birthday;
    private ArrayList<String> commands;

    public Animal(String name, LocalDate birthday) {
        this.id = ++totalAnimals;
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void displayCommands() {
        System.out.println("Команды животного " + name + ": " + String.join(", ", commands));
    }
}
