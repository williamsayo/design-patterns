package factory;

import abstracts.Button;
import abstracts.Checkbox;
import abstracts.TextField;
import abstracts.UiFactory;
import concrete.button.ButtonA;
import concrete.checkbox.CheckboxA;
import concrete.textfield.TextFieldA;

public class AFactory extends UiFactory {
    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }

}
