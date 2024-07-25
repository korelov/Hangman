package hangman;

import java.util.Scanner;

public class Menu {
    private final static String GAME_NAME =
            """
                    ██╗░░██╗░█████╗░███╗░░██╗░██████╗░███╗░░░███╗░█████╗░███╗░░██╗
                    ██║░░██║██╔══██╗████╗░██║██╔════╝░████╗░████║██╔══██╗████╗░██║
                    ███████║███████║██╔██╗██║██║░░██╗░██╔████╔██║███████║██╔██╗██║
                    ██╔══██║██╔══██║██║╚████║██║░░╚██╗██║╚██╔╝██║██╔══██║██║╚████║
                    ██║░░██║██║░░██║██║░╚███║╚██████╔╝██║░╚═╝░██║██║░░██║██║░╚███║
                    ╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝
                    """;
    private final Scanner scanner = new Scanner(System.in);
    private final Game game = new Game();

    public void init() {
        System.out.println("Добро пожаловать в игру Виселица");
        System.out.println(GAME_NAME);
        while (true) {
            System.out.println("""
                    Для старта игры нажмите 1
                    Для выхода нажмите 0
                    """);
            String menuLetter = scanner.nextLine();
            if (!menuLetter.matches("[0 - 1]")) {
                System.out.println("Введите цифры 0 или 1");
                continue;
            }
            int menuNumber = Integer.parseInt(menuLetter);
            if (menuNumber != 0) {
                game.start(scanner);
                System.out.println(GAME_NAME);
            } else {
                System.out.println("Пока");
                break;
            }
        }
    }
}