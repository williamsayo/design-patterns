package factory;

import abstracts.Button;
import abstracts.Checkbox;
import abstracts.TextField;
import abstracts.UiFactory;
import concrete.button.ButtonB;
import concrete.checkbox.CheckboxB;
import concrete.textfield.TextFieldB;

public class BFactory extends UiFactory {
    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }

}
