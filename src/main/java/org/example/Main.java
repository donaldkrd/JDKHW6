package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        Map<Integer, String> result = new HashMap<>();
        for(int i = 0; i < 1000; i++ ){
            int[] doors = {0,0,0};
            doors[rand.nextInt(3)] = 1;
            int choiceGamer = rand.nextInt(3);
            int showDoor;
            do{
                showDoor = rand.nextInt(3);
            }while(doors[showDoor] == 1 || showDoor == choiceGamer);

            if (doors[choiceGamer] == 1) {
                result.put(i, "Выиграл не меняя решения");
            } else { // В обратном случае
                result.put(i, "Выиграл изменив первичное решение");
            }
        }
        printResult(result);
    }
    private static void printResult(Map<Integer, String> res){
        int noSwitchChoice = 0;
        int switchChoice= 0;
        for (String result : res.values()) {
            if (result.equals("Выиграл не меняя решения")) {
                noSwitchChoice++;
            } else {
                switchChoice++;
            }
        }
        System.out.println("Всего игр сыграно: " + res.size());
        System.out.println("Выиграл, не меняя решения: " + noSwitchChoice + ", при этом проиграл: " + (res.size() - noSwitchChoice));
        System.out.println("Выиграл, изменив своё решение: " + switchChoice + ", при этом проиграл: " + (res.size() - switchChoice));
    }
}