import java.time.LocalDate;
import java.util.ArrayList;

public class Pets extends Animal{

    public Pets(String name, LocalDate birthday) {
        super(name, birthday);
    }


    @Override
    public void addCommand(String command) {
        super.addCommand(command);
    }

    @Override
    public ArrayList<String> getCommands() {
        return super.getCommands();
    }

    @Override
    public void displayCommands() {
        super.displayCommands();
    }
}
