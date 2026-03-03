package concrete.textfield;

import abstracts.TextField;

public class TextFieldB extends TextField {

    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(this.text.length(), 20);
        String border = "+" + "-".repeat(width + 2) + "+";
        System.out.println(border);
        System.out.printf("| %-" + width + "s |\n", this.text);
        System.out.println(border);
    }
}
