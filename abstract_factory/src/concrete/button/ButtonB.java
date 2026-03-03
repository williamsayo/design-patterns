package concrete.button;

import abstracts.Button;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }
    @Override
    public void display() {
        int width = this.text.length() + 4;
        String border = "+" + "=".repeat(width) + "+";
        System.out.println(border);
        System.out.println("|  " + this.text + "  |");
        System.out.println(border);
    }
}
