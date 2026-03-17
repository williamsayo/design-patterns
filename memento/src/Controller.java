import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private final ObservableList<IMemento> history = FXCollections.observableArrayList(); // Memento history
    private final ObservableList<IMemento> redoHistory = FXCollections.observableArrayList(); // Memento history
    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            //  Save current state when user presses undo
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState);

            System.out.println("Memento found in history");
            IMemento previousState = history.removeLast();
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo Memento found in history");
            IMemento redoState = redoHistory.removeLast();
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        //  clear redo state when user makes new action
        redoHistory.clear();
    }

    public ObservableList<IMemento> getHistory() {
        return history;
    }

    public Model getModel() {
        return model;
    }
}
