package abstracts;

public abstract class Button extends UiElement {
    public Button(String text) {
        super(text);
    }
    public abstract void display();
}