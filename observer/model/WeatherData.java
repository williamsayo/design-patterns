package observer.model;

public class WeatherData extends WeatherObservable {
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers(this.temperature);
    }

    public double getTemperature() {
        return temperature;
    }
}