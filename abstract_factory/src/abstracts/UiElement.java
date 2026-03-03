package abstracts;

public abstract class UiElement {
    public String text;
    public UiElement(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
