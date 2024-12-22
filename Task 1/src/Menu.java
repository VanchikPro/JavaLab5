import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\n--- Главное меню ---");
        System.out.println("1. Выполнить расчет");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Выберите опцию: ");
    }

    // Корректный выбор опции меню
    public int Choice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.print("Ошибка: выберите опцию от 1 до 4. \nПовторите ввод: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: введите число. \nПовторите ввод: ");
            }
        }
    }

    // Корректная масса
    public double ValidMass() {
        System.out.print("Введите массу объекта в килограммах: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Ошибка: введите положительное число. \nПовторите ввод: ");
            scanner.next();
        }
        double mass = scanner.nextDouble();
        if (mass > 0) {
            return mass;
        } else {
            System.out.println("Ошибка: масса должна быть положительным числом.");
            return ValidMass();
        }
    }

    // Корректная скорость
    public double ValidSpeed() {
        System.out.print("Введите скорость объекта в метрах в секунду: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Ошибка: введите положительное число. \nПовторите ввод: ");
            scanner.next();
        }
        double speed = scanner.nextDouble();
        if (speed >= 0) {
            return speed;
        } else {
            System.out.println("Ошибка: скорость не может быть отрицательной.");
            return ValidSpeed();
        }
    }

    // Информация о программе
    public void displayProgramInfo() {
        System.out.println("Эта программа рассчитывает кинетическую энергию объекта по формуле: E = 0.5 * m * v^2.");
    }

    // Информация о разработчике
    public void displayDeveloperInfo() {
        System.out.println("Разработчик программы: Дорофиенко Иван Сергеевич РИМ-140970.");
    }
}
