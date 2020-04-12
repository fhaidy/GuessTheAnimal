import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gameOver = 0;
        Animals animals = startListOfAnimals();
        while(gameOver == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Think in one animal and the press any key to start the game.");
            System.out.println("Type 1 to start the game or 0 to end the game");
            int cmd = getUserInput(sc);
            if (cmd == 0)
                finishGame();
            ArrayList<String> characteristics = new ArrayList<>();
            System.out.flush();
            System.out.println("Answer the question with Y to true or N to false.");
            System.out.println("About your animal:");
            for (Animal animal: animals.toList()) {
                for (String characteristic: animal.characteristics) {
                    System.out.println(characteristic + "?");
                    String answer = getUserAnswer(sc);
                    if (checkAnswer(answer, "Y")){
                        characteristics.add(characteristic);
                    }
                }
            }
            if (!characteristics.isEmpty()){
                Animal guessedAnimal = animals.getAnimalWithMoreMatchingCharacteristic(characteristics);
                System.out.println("Your animal is: " + guessedAnimal.getName());
                System.out.println("Answer with Y to true or N to false.");
                String answer = getUserAnswer(sc);

                if (checkAnswer(answer, "Y")){
                    System.out.println("Game Over.");
                }else{
                    animals.addAnimal(createUserAnimal(sc));
                    System.out.println("I'll get it right on my next attempt !!");
                }
            }else{
                System.out.println("I was unable to guess your animal.");
                System.out.println("Congratulations !!");
                animals.addAnimal(createUserAnimal(sc));
                System.out.println("I'll get it right on my next attempt !!");
            }
            gameOver = checkForPlayAgain(sc);
        }
    }

    private static Animal createUserAnimal(Scanner sc) {
        ArrayList<String> auxCharacteristics = new ArrayList<>();
        System.out.println("Tell me which was your animal?");
        String animalName = sc.nextLine();
        System.out.println("Tell me one characteristic about your animal");
        auxCharacteristics.add(sc.nextLine());
        return new Animal(animalName, auxCharacteristics);
    }

    private static int checkForPlayAgain(Scanner sc) {
        int gameOver;
        System.out.println("Do you want to play again ? (Y to true or N to false)");
        String playAgain = getUserAnswer(sc);
        gameOver = checkForGameOver(playAgain);
        return gameOver;
    }

    private static boolean checkAnswer(String answer, String expected) {
        return answer.toUpperCase().equals(expected.toUpperCase());
    }

    private static int checkForGameOver(String playAgain) {
        int gameOver = 0;
        if (checkAnswer(playAgain, "N")) {
            gameOver = 1;
        }
        return gameOver;
    }

    private static String getUserAnswer(Scanner sc) {
        String answer = sc.nextLine();
        while(!checkAnswer(answer, "Y") && !checkAnswer(answer, "N")){
            System.out.println("Answer the question with Y to true or N to false.");
            answer = sc.nextLine();
        }
        return answer;
    }

    private static int getUserInput(Scanner sc) {
        int userInput = sc.nextInt();
        while (userInput != 0 && userInput != 1){
            System.out.println("Wrong input !!");
            System.out.println("Type 1 to start the game or 0 to end the game");
            userInput = sc.nextInt();
        }
        return userInput;
    }

    private static void finishGame() {
        System.exit(0);
    }

    private static Animals startListOfAnimals(){
        Animals animals = new Animals();
        ArrayList<String> characteristics = new ArrayList<>();
        characteristics.add("It Barks");
        animals.addAnimal(new Animal("Dog", characteristics));
        return animals;
    }
}
