package template_method;

public class Main {
    public static void main(String[] args) {
        Game game = new GuessGame();
        game.play(2);
    }
}
