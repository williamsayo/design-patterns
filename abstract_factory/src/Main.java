import abstracts.Button;
import abstracts.Checkbox;
import abstracts.TextField;
import factory.AFactory;
import factory.BFactory;

public class Main {
    public static void main(String[] args) {
        Button button =new AFactory().createButton("Button");
        TextField textField =new AFactory().createTextField("Text field");
        Checkbox checkbox =new AFactory().createCheckbox("Checkbox");


        Button button2 =new BFactory().createButton("Click me");
        TextField textField2 =new BFactory().createTextField("Text field2");
        Checkbox checkbox2 =new BFactory().createCheckbox("Check me");

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
