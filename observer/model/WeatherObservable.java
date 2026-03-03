package observer.model;

import observer.view.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherObservable implements Observable{
    private final List<Observer> weatherStationObservers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer weatherStationObserver){
        weatherStationObservers.add(weatherStationObserver);
    }

    @Override
    public void removeObserver(Observer weatherStationObserver){
        weatherStationObservers.remove(weatherStationObserver);
    }

    @Override
    public void notifyObservers(double temperature){
        for(Observer weatherStationObserver : weatherStationObservers){
            weatherStationObserver.update(temperature);
        }
    }
}
