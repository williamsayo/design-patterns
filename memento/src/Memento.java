import java.time.Instant;
import java.time.LocalTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalTime timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = LocalTime.now();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalTime getTimestamp() {
        return timestamp;
    }
}
