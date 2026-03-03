package abstracts;

public abstract class UiFactory {
    public abstract TextField createTextField(String text);
    public abstract Button createButton(String text);
    public abstract Checkbox createCheckbox(String text);
}
