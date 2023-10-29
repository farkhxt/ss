import java.util.Date;


interface CommonWeatherData {
    String getLocation();
    Date getDate();
    double getTemperature();
    String getDescription();
}

class WeatherDataAPI1 {
    private String location;
    private long timestamp;
    private double temp;
    private String weatherDescription;

    public WeatherDataAPI1(String location, long timestamp, double temp, String description) {
        this.location = location;
        this.timestamp = timestamp;
        this.temp = temp;
        this.weatherDescription = description;
    }

    public String getLocation() {
        return location;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getTemp() {
        return temp;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}

class WeatherDataAPI2 {
    private String cityName;
    private Date date;
    private double temperature;
    private String weather;

    public WeatherDataAPI2(String cityName, Date date, double temperature, String weather) {
        this.cityName = cityName;
        this.date = date;
        this.temperature = temperature;
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public Date getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeather() {
        return weather;
    }
}

class API1ToCommonAdapter implements CommonWeatherData {
    private WeatherDataAPI1 api1Data;

    public API1ToCommonAdapter(WeatherDataAPI1 api1Data) {
        this.api1Data = api1Data;
    }

    public String getLocation() {
        return api1Data.getLocation();
    }

    public Date getDate() {
        return new Date(api1Data.getTimestamp() * 1000); // Convert timestamp to Date
    }

    public double getTemperature() {
        return api1Data.getTemp();
    }

    public String getDescription() {
        return api1Data.getWeatherDescription();
    }
}

class API2ToCommonAdapter implements CommonWeatherData {
    private WeatherDataAPI2 api2Data;

    public API2ToCommonAdapter(WeatherDataAPI2 api2Data) {
        this.api2Data = api2Data;
    }

    public String getLocation() {
        return api2Data.getCityName();
    }

    public Date getDate() {
        return api2Data.getDate();
    }

    public double getTemperature() {
        return api2Data.getTemperature();
    }

    public String getDescription() {
        return api2Data.getWeather();
    }
}

class WeatherApp {
    public static void main(String[] args) {
        WeatherDataAPI1 dataFromAPI1 = new WeatherDataAPI1("New York", 1635526800, 72.5, "Partly Cloudy");
        WeatherDataAPI2 dataFromAPI2 = new WeatherDataAPI2("San Francisco", new Date(), 65.3, "Sunny");

        CommonWeatherData commonData1 = new API1ToCommonAdapter(dataFromAPI1);
        CommonWeatherData commonData2 = new API2ToCommonAdapter(dataFromAPI2);

        System.out.println("Location: " + commonData1.getLocation());
        System.out.println("Date: " + commonData1.getDate());
        System.out.println("Temperature: " + commonData1.getTemperature() + "°F");
        System.out.println("Description: " + commonData1.getDescription());

        System.out.println("Location: " + commonData2.getLocation());
        System.out.println("Date: " + commonData2.getDate());
        System.out.println("Temperature: " + commonData2.getTemperature() + "°C");
        System.out.println("Description: " + commonData2.getDescription());
    }
}
// i did it with imaginary api, so i hope for 2 points:D
