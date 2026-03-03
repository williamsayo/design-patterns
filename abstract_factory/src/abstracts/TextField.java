package abstracts;

public abstract class TextField extends UiElement {
    public TextField(String text) {
        super(text);
    }
    public abstract void display();
}
