import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToyShop toyShop = new ToyShop();

        while (true) {
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Обновить вес игрушки");
            System.out.println("3. Выберите выигрышную игрушку");
            System.out.println("4. Выдать выигрышную игрушку");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите идентификатор игрушки:");
                    int id = scanner.nextInt();
                    System.out.println("Введите название игрушки:");
                    String name = scanner.next();
                    System.out.println("Введите количество игрушек:");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вес игрушки (%):");
                    double weight = scanner.nextDouble();
                    Toy toy = new Toy(id, name, quantity, weight);
                    toyShop.addToy(toy);
                    System.out.println("Добавлена игрушка.");
                    break;

                case 2:
                    System.out.println("Введите идентификатор игрушки:");
                    int toyId = scanner.nextInt();
                    System.out.println("Введите новый вес (%):");
                    double toyWeight = scanner.nextDouble();
                    toyShop.updateToyWeight(toyId, toyWeight);
                    System.out.println("Обновлен вес игрушки.");
                    break;

                case 3:
                    Toy selectedToy = toyShop.selectToy();
                    if (selectedToy != null) {
                        System.out.println("Игрушка-победитель: " + selectedToy.getName());
                    } else {
                        System.out.println("Игрушка не выбрана.");
                    }
                    break;

                case 4:
                    try {
                        toyShop.issueToy();
                    } catch (IOException e) {
                        System.out.println("Ошибка записи в файл.");
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
                    break;
            }
        }
    }
}