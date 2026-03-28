import calender.CalendarToNewDateAdapter;
import calender.NewDateInterface;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();
        int daysToAdvance = 6;
        date.setYear(2026);
        date.setMonth(3);
        date.setDay(28);
        System.out.println("Current date is: " + date);
        date.advanceDays(daysToAdvance);
        System.out.printf("%s days have passed and the Current date is now %s\n ", daysToAdvance, date);
    }
}
