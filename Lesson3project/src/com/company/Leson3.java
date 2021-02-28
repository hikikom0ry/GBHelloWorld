package com.company;

import java.util.Random;
import java.util.Scanner;


public class Leson3 {
    static int guessNumber(){
        Random x = new Random();
        int randomNumber = x.nextInt(10);
        return randomNumber;
    }
    static String someWord(){
        Random rd = new Random();
        String randomFruit = words[rd.nextInt(26)];
        return randomFruit;
    }
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static void main(String[] args) {
//        boolean quit = false;
//        boolean success = false;
//        do{
//            int guessedNumber = guessNumber();
//            System.out.println("Guessed a number from 0 to 9");
//            Scanner sc = new Scanner(System.in);
//            for(int i = 3; i > 0; i--){
//
//                int answer = sc.nextInt();
//                if (guessedNumber < answer) System.out.println("The guessed number is less");
//                else if (guessedNumber > answer) System.out.println("The guessed number is more");
//                else{
//                    System.out.println("Congratulation! You guess the number. \n " +
//                            "Do you want to play again? \n" +
//                            "Type 1 for continue, type 0 for exit");
//                    int continueOrQuit = sc.nextInt();
//                    quit = (continueOrQuit ==1) ? false : true;
//                    success = true;
//                    break;
//                }
//            }
//            if (!success){
//                System.out.println("You lost. \n " +
//                        "Do you want to play again? \n" +
//                        "Type 1 for continue, type 0 for exit");
//                int continueOrQuit = sc.nextInt();
//                quit = (continueOrQuit ==1) ? false : true;
//            }
//
//        } while (quit!=true);

        // Получаем вариант названия от пользователя

        Scanner scanner = new Scanner(System.in);
        String inputWord;
        String randomWord = someWord();
        int inputWordLength;
        int randomWordLength = randomWord.length();


        do {
            System.out.println("Угадайте слово");
            inputWord = scanner.nextLine();
            inputWordLength = inputWord.length();

            // Сравниваем длину загаданного фрукта с длинной названия фрукта введенного пользователем
            //для определения меньшего слова
            if (!(inputWord.equals(randomWord))) {
                int wordLength = (inputWordLength < randomWordLength) ?
                        inputWordLength : randomWordLength;
                String mask = "";

                // Сравниваем посимвольно слова. Если символы на одинаковых позициях повторяются,
                // то добавляем символ в маску, если нет, то добавляем символ #
                for (int i = 0; i < wordLength; i++) {
                    if (randomWord.charAt(i) == (inputWord.charAt(i))) {
                        mask += randomWord.charAt(i);
                    } else {
                        mask += "#";
                    }
                }

                //Добиваем недостающие символы #
                for (int i = 0; i < 15 - wordLength; i++) {
                    mask += "#";
                }
                System.out.println(mask);
            } else {
                System.out.println("Вы угадали. Это слово "+ inputWord);
                break;
            }
        }while(!(inputWord.equals(randomWord)));
    }
}
