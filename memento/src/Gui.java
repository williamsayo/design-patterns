import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Button historyBtn;
    private ListView<IMemento> listView;

    public void start(Stage stage) {

        controller = new Controller(this);

        listView = new ListView<>();
        listView.setItems(controller.getHistory());

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change and Ctrl-Y to redo change.");
        label.setPadding(insets);

        historyBtn = new Button("History");
        historyBtn.setPadding(new Insets(5, 10, 5, 10));

        VBox.setMargin(historyBtn, new Insets(0, 0, 0, 10));

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox,historyBtn, label);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        historyBtn.setOnAction(event -> {
            viewHistory();
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            }
            else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void viewHistory() {
        // Create new window (Stage)
        Stage historyStage = new Stage();
        historyStage.setTitle("Memento History Window");

        Insets insets = new Insets(10, 10, 10, 10);
        Label label = new Label("Select history to restore changes");
        label.setPadding(insets);

        listView.setCellFactory(lv -> new ListCell<>() {
            protected void updateItem(IMemento item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : formatMetaData(item));
            }
        });

        listView.setOnMouseClicked(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            int listSize = listView.getItems().size();
            if  (index < listSize && !(index >= 0)) return;

            controller.getHistory().subList(index + 1, listSize).clear();
            IMemento previousState = controller.getHistory().remove(index);
            controller.getModel().restoreState(previousState);
            updateGui();
        });

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(label,listView);
        vBox.setPadding(insets);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox, 300, 200);
        historyStage.setScene(scene);

        // Show new window
        historyStage.show();
    }

    private String formatMetaData(IMemento iMemento) {
        Memento memento = (Memento) iMemento;
        String checkboxMetadata = memento.isSelected() ? "checked" : "unchecked";
        String timestamp = DateTimeFormatter.ofPattern("HH:mm:ss").format(memento.getTimestamp());
        return String.format("[%s] Options: %s  | Checkbox: %s", timestamp,java.util.Arrays.toString(memento.getOptions()), checkboxMetadata);
    }
}
