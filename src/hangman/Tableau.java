package hangman;

import java.util.Arrays;

public class Tableau {
    private String correctAnswer;
    private String[] lettersOnTableau;

    public void init(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.lettersOnTableau = new String[correctAnswer.length()];
        Arrays.fill(this.lettersOnTableau, "*");
    }

    public void printTableau() {
        for (int i = 0; i < lettersOnTableau.length; i++) {
            if (i < lettersOnTableau.length - 1) {
                System.out.print(lettersOnTableau[i].toUpperCase() + " ");
            } else {
                System.out.print(lettersOnTableau[i].toUpperCase() + "\n");
            }
        }
    }

    public boolean containsUnknownLetters() {
        return Arrays.asList(lettersOnTableau).contains("*");
    }

    public boolean checkLetters(String letter) {
        if (correctAnswer.toUpperCase().contains(letter.toUpperCase())) {
            for (int i = 0; i < correctAnswer.length(); i++) {
                if (String.valueOf(correctAnswer.charAt(i)).equalsIgnoreCase(letter)) {
                    if (lettersOnTableau[i].equals("*")) {
                        lettersOnTableau[i] = letter.toUpperCase();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
