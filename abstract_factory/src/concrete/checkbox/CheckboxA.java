package concrete.checkbox;

import abstracts.Checkbox;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[_] " + this.text);
    }
}
