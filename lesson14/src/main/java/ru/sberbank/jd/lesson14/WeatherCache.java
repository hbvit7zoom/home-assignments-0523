package ru.sberbank.jd.lesson14;

import java.util.HashMap;
import java.util.Map;

/**
 * Weather cache.
 */
public class WeatherCache {

    private final Map<String, WeatherInfo> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    /**
     * Constructor.
     *
     * @param weatherProvider - weather provider
     */
    public WeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Get ACTUAL weather info for current city or null if current city not found.
     * If cache doesn't contain weather info OR contains NOT ACTUAL info then we should download info
     * If you download weather info then you should set expiry time now() plus 5 minutes.
     * If you can't download weather info then remove weather info for current city from cache.
     *
     * @param city - city
     * @return actual weather info
     */
    public WeatherInfo getWeatherInfo(String city) {
        // should be implemented
        return null;
    }

    /**
     * Remove weather info from cache.
     **/
    public void removeWeatherInfo(String city) {
        // should be implemented
    }
}

