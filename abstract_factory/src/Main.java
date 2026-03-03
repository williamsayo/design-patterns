import abstracts.Button;
import abstracts.Checkbox;
import abstracts.TextField;
import abstracts.UiFactory;
import factory.AFactory;
import factory.BFactory;

public class Main {
    public static void main(String[] args) {
        UiFactory factory = new AFactory();
        Button button = factory.createButton("Button");
        TextField textField =factory.createTextField("Text field");
        Checkbox checkbox =factory.createCheckbox("Checkbox");

        UiFactory bFactory = new BFactory();
        Button button2 =bFactory.createButton("Click me");
        TextField textField2 =bFactory.createTextField("Text field2");
        Checkbox checkbox2 =bFactory.createCheckbox("Check me");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("===========B Style UI elements===========");

        button2.display();
        textField2.display();
        checkbox2.display();

        button.setText("Click to delete");
        button.display();

    }
}
