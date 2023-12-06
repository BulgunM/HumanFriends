import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Animal> animals = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить животного");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучить новой команде");
            System.out.println("4. Список животных по дате рождения");
            System.out.println("5. Вывести всех животных");
            System.out.println("6. Выход");
            System.out.print("Введите нужную цифру: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    listCommands();
                    break;
                case 3:
                    trainCommand();
                    break;
                case 4:
                    listAnimalsByBirthdate();
                    break;
                case 5:
                    displayTotalAnimals();
                    break;
                case 6:
                    System.out.println("Выход!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильная цифра меню. Введите от 1 до 6:");
            }
        }
    }

    private static void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите тип животного: ");
        String type = scanner.nextLine();

        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.println("Введите дату рождения животного в формате гггг-мм-дд: ");
        String birthdateStr = scanner.nextLine();

        LocalDate birthdate = LocalDate.parse(birthdateStr);

        Animal animal;

        switch (type.toLowerCase()) {
            case "собака":
                animal = new Dogs(name, birthdate);
                break;
            case "кошка":
                animal = new Cats(name, birthdate);
                break;
            case "хомяк":
                animal = new Humsters(name, birthdate);
                break;
            case "лошадь":
                animal = new Horses(name, birthdate);
                break;
            case "верблюд":
                animal = new Camels(name, birthdate);
                break;
            case "осел":
                animal = new Donkeys(name, birthdate);
                break;
            default:
                System.out.println("Неподходящий тип");
                return;
        }

        animals.add(animal);
        System.out.println(animal.getName() + " добавлен в список животных");
    }

    private static void listCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id животного: ");
        int id = scanner.nextInt();

        Animal animal = findAnimalById(id);

        if (animal != null) {
            animal.displayCommands();
        } else {
            System.out.println("Животное с id " + id + " не найдено");
        }
    }

    private static void trainCommand() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id животного: ");
        int id = scanner.nextInt();

        Animal animal = findAnimalById(id);

        if (animal != null) {
            System.out.print("Введите команду, которой хотите обучить: ");
            String newCommand = scanner.next();

            animal.addCommand(newCommand);
            System.out.println(animal.getName() + " выучил новую команду: " + newCommand);
        } else {
            System.out.println("Животное с id " + id + " не найдено");
        }
    }

    private static void listAnimalsByBirthdate() {
        animals.sort((a1, a2) -> a1.getBirthday().compareTo(a2.getBirthday()));

        System.out.println("\nЖивотные отсортированы по дате рождения:");
        for (Animal animal : animals) {
            System.out.println("ID: " + animal.getId() + ", Имя: " + animal.getName() +
                    ", Дата рождения: " + animal.getBirthday());
        }
    }

    private static void displayTotalAnimals() {
        System.out.println("\nОбщее количество животных: " + Animal.totalAnimals);
    }

    private static Animal findAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }
}