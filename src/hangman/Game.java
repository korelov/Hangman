package hangman;

import hangman.enums.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String RESOURCES_WORD_TXT = "src/resources/word.txt";
    private final Random random = new Random();
    private final File file = new File(RESOURCES_WORD_TXT);
    private final Tableau tableau = new Tableau();
    private int errorCount = 0;

    public void start(Scanner scanner) {
        StringBuilder errorLetter = new StringBuilder();
        StringBuilder enteredLetter = new StringBuilder();
        String correctAnswer = readWord();
        tableau.init(correctAnswer);

        while (true) {
            System.out.println(Hangman.values()[errorCount].getHangman());

            System.out.print("Слово ");
            tableau.printTableau();
            System.out.printf("Ошибки (%d): %s\n", errorCount, errorLetter);

            if (errorCount == 6) {
                System.out.printf("Вы проиграли , загадано слово - %s\n\n", correctAnswer.toUpperCase());
                errorCount = 0;
                break;
            }
            String letter = enterLetters(scanner, enteredLetter);

            if (!tableau.checkLetters(letter)) {
                errorLetter.append(letter);
                errorCount++;
            }
            if (!tableau.containsUnknownLetters()) {
                System.out.println("Вы победили !! \n");
                break;
            }
        }
    }

    private String readWord() {
        String word = "";
        int count = 0;
        int randomWord = random.nextInt(81);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                word = scanner.nextLine();
                if (count == randomWord) {
                    break;
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    private String enterLetters(Scanner scanner, StringBuilder enteredLetter) {
        while (true) {
            System.out.println("Введите букву");
            String letter = scanner.nextLine();
            if (letter.length() == 1 && letter.matches("^[а-яА-Я]")) {
                if (enteredLetter.indexOf(letter) != -1) {
                    System.out.println("ВЫ уже пробовали эту букву");
                    continue;
                }
                enteredLetter.append(letter);
                return letter;
            } else {
                System.out.println("Ошибка! введите одну русскую букву");
            }
        }
    }

}