import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        boolean exit = false;

        // Динамический список объектов
        ArrayList<PhysicalObject> objects = new ArrayList<>();

        while (!exit) {
            menu.displayMenu();
            int choice = menu.Choice();

            switch (choice) {
                case 1:
                    double mass = menu.ValidMass();
                    double speed = menu.ValidSpeed();
                    KineticEnergy object = new KineticEnergy(mass, speed);
                    objects.add(object); // Добавление объекта в список
                    System.out.printf("Кинетическая энергия объекта: %.2f Джоулей\n", object.calculateEnergy());
                    break;
                case 2:
                    menu.displayProgramInfo();
                    break;
                case 3:
                    menu.displayDeveloperInfo();
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    exit = true;
                    break;
            }
        }

        // Обработка списка (массива) объектов с использованием полиморфизма
        System.out.println("\nРезультаты работы программы:");
        for (int i = 0; i < objects.size(); i++) {
            PhysicalObject obj = objects.get(i);
            System.out.println("Расчет " + (i + 1));
            System.out.println(obj.toString()); // Вызов полиморфного метода toString()
        }

        scanner.close();
    }
}
