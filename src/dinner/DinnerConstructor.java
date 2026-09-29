package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<?, ?> dinnersByType = ??? // хранилище блюд: ключ — тип блюда (например, "Суп"), значение — список названий блюд этого типа
    Random random = new Random(); //этот вспомогательный класс поможет сделать произвольные сочетания блюд

    //в этом методе мы добавляем компонент в подборку
    public void addNewDish(String dishType, String dishName) {
        ??? dishesForType; //переменая для списка блюд
        if (dinnersByType.???(dishType)) { //здесь мы должны проверить, содержит ли наше хранилище такое блюдо
            dishesForType = ??//если мы уже работали с этим типом - используем существующий список
        } else {
            dishesForType = //для нового типа блюд создаём пустой список компонентов.
            dinnersByType.???(dishType, dishesForType); //запоминаем новый список в хранилище
        }

        dishesForType.???(dishName); //независимо от того, новый это список или существующий - добавим в него конкретное блюдо
    }

    //метод для генерирования вариантов комбинации блюд
    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ??? combos = ??? //пустой список для хранения получившихся комбинаций блюд
        for (???; i <= comboNumber; ???) {
            ??? combo = generateCombo(dishTypes); //одна комбинация блюд генерируется в отдельном методе
            combos.add(combo);
        }
        return combos;
    }


    //метод для проверки дубликатов блюд
    public boolean checkType(String type) {
        return dinnersByType.???(type); //если хранилище уже содержит такое блюдо - вернём true
    }

    //метод для генерирования одной комбинации блюд
    private ??? ***(??? dishTypes) {
        ??? selectedDishes = ???;
        for (??? dishType: dishTypes) {
            ??? availableDishes = dinnersByType.???(dishType); //достаём из хранилища варианты блюд по типу
            String selectedDish = ???(availableDishes); //полцчим произвольное блюдо
            selectedDishes.???(selectedDish); //добавим блюдо в подборку комбинацию
        }
        return selectedDishes;
    }

    private String getRandomDish(??? availableDishes) {
        int numberOfDishesForType = availableDishes.size(); //получаем общее количество доступных блюд этого типа
        int dishIndex = random.nextInt(numberOfDishesForType); //генерируем случайное число от 0 до (кол-во блюд - 1), чтобы выбрать случайное блюдо
        String selectedDish = availableDishes.???(dishIndex); //выберем произвольное блюдо по индексу
    }

}
