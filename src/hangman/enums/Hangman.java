package hangman.enums;

public enum Hangman {
    STAGE_1("""
                  _______
                 |/      |
                 |
                 |
                 |
                 |
                _|___
            """) ,
    STAGE_2("""
                _______
                 |/      |
                 |      (_)
                 |
                 |
                 |
                _|___
            """),
    STAGE_3("""
                  _______
                 |/      |
                 |      (_)
                 |      \\|
                 |
                 |
                _|___
            """) ,
    STAGE_4("""
                _______
                 |/      |
                 |      (_)
                 |      \\|/
                 |
                 |
                _|___
            """),
    STAGE_5("""
                  _______
                 |/      |
                 |      (_)
                 |      \\|/
                 |       |
                 |
                _|___
            """) ,
    STAGE_6("""
                _______
                 |/      |
                 |      (_)
                 |      \\|/
                 |       |
                 |      /
                _|___
            """),
    STAGE_7("""
                  _______
                 |/      |
                 |      (_)
                 |      \\|/
                 |       |
                 |      / \\
                _|___
            """);
    private String hangman;

    public String getHangman() {
        return hangman;
    }

    Hangman(String hangman) {
        this.hangman = hangman;
    }
}
