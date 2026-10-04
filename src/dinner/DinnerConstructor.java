package dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String,ArrayList<String>> dinnersByType = new HashMap<>();
    Random random = new Random();

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType;
        if (dinnersByType.containsKey(dishType)) {
            dishesForType = dinnersByType.get(dishType);
        } else {
            dishesForType = new ArrayList<>();
            dinnersByType.put(dishType, dishesForType);
        }

        dishesForType.add(dishName);
    }


    public ArrayList<ArrayList<String>> generatedCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 1; i < comboNumber; i++) { //теперь нумерация начинается с единицы
            ArrayList<String> combo = generatedCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }


    //метод для проверки дубликатов блюд
    public boolean checkType(String type) {
        return dinnersByType.containsKey(type); //если хранилище уже содержит такое блюдо - вернём true
    }

    //метод для генерирования одной комбинации блюд
    private ArrayList<String> generatedCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();
        for (String dishType: dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }
        return selectedDishes;
    }

    private String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);


        return availableDishes.get(dishIndex);
    }

}
