package observer.view;

public class WeatherObserver implements Observer {
    private final String observerName;

    public WeatherObserver(String observerName){
        this.observerName = observerName;
    }

    @Override
    public void update(double temperature) {
        System.out.println("[" + this.observerName + "] observer received temperature update.");
        System.out.println("current temperature: " + temperature);
    }

    public String getObserverName() {
        return observerName;
    }
}
