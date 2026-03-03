package observer.view;

import observer.model.WeatherData;

import java.util.Random;

public class WeatherStation implements Runnable {
    private static final double MAX_TEMP =  50.0;
    private static final double MIN_TEMP = -40.0;
    private final WeatherData weatherStationData = new WeatherData();
    Random random = new Random();

    public WeatherStation() {
        weatherStationData.setTemperature(random.nextInt(50));
        System.out.printf("[WeatherStation] Initialized — starting temperature: %.1f°C%n", weatherStationData.getTemperature());
    }

    public WeatherData getWeatherDataObserver() {
        return weatherStationData;
    }

    private void updateTemperature() {
        double delta = random.nextBoolean() ? 1.0 : -1.0;
        double temperature = Math.max(MIN_TEMP, Math.min(MAX_TEMP, weatherStationData.getTemperature()) + delta);
        weatherStationData.setTemperature(temperature);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try{
                int sleepMs = 1000 + random.nextInt(4000);
                Thread.sleep(sleepMs);
                updateTemperature();
            } catch (InterruptedException e) {
                System.out.println("[WeatherDataStation] Thread interrupted — shutting down.");
                Thread.currentThread().interrupt();
            }

        }
    }
}
