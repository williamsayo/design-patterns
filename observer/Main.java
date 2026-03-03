package observer;

import observer.view.WeatherObserver;
import observer.view.WeatherStation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation weatherStation = new WeatherStation();

        WeatherObserver home = new WeatherObserver("Home");
        WeatherObserver farm = new WeatherObserver("Farm");
        WeatherObserver school = new WeatherObserver("School");

        weatherStation.getWeatherDataObserver().addObserver(home);
        weatherStation.getWeatherDataObserver().addObserver(farm);
        weatherStation.getWeatherDataObserver().addObserver(school);

        Thread stationThread = new Thread(weatherStation, "WeatherStationThread");
        stationThread.start();

        System.out.println("\n─── All observers active ───");
        Thread.sleep(10_000);

        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("  Removing " + home.getObserverName() + " observer …");
        System.out.println("══════════════════════════════════════════════════");
        weatherStation.getWeatherDataObserver().removeObserver(home);

        System.out.println("\n─── Running without "+ home.getObserverName() +  " (10 seconds) ───");
    }
}
