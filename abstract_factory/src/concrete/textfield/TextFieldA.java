package concrete.textfield;

import abstracts.TextField;

public class TextFieldA extends TextField {

    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(this.text.length(), 20);
        System.out.println("." + "-".repeat(width + 2) + ".");
        System.out.printf("| %-" + width + "s |\n", this.text);
        System.out.println("'" + "-".repeat(width + 2) + "'");
    }
}
