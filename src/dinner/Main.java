package dinner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default: //добавлена ветка default с коротким сообщением.
                    System.out.println("Такой команды нет");


            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        int numberOfCombos = 0;
        boolean isValidNumberOfCombos = false; //переменная-флаг для цикла
        while (!isValidNumberOfCombos){ //сам цикл, чтобы пользователь мог много раз ошибаться, но в конечном итоге ввел
            // данные в правильном виде
        try { //начала конструкции, которая проверяет исключения*
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            numberOfCombos = scanner.nextInt();
            scanner.nextLine();//очистка буфера
            isValidNumberOfCombos = true;// если пользователь ввел число, то "флаг" становится true и цикл останавливается
        }catch (InputMismatchException e){ //блок обработки исключения с типом исключения
            System.out.println("вы ввели строку, а нужно число"); //объяснение пользователю
            scanner.nextLine();//очистка буфера
        }
        }


        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> selectedTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                selectedTypes.add(nextItem);
            } else {
                System.out.println("Такой тип блюд мы еще не умеем готовить. Попробуйте что-нибудь другое!");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        ArrayList<ArrayList<String>> comb = dc.generatedCombos(numberOfCombos, selectedTypes);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + i);
            System.out.println(comb.get(i));
        }
    }
}
//* продолжу свой комментарий тут, чтобы не нагружать блок с кодом.
// в ходе курса мы эту кострукцию еще не проходили, но я о ней узнала на одной из конференций и очень хотела применить на практике

