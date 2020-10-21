import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: rsv
 * Date: 03.10.2020
 * Time: 18:29
 */
public class CurrentWeather {

    private static final String API_KEY = "5e75240ff38b201c86e5fe31f01f5e91";

    public static void main(final String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Please pass your city as argument");
            System.exit(0);
        }
        String cityName = args[0];
        URL url = new URL(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, API_KEY));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        String response = connection.getResponseMessage();
        System.out.printf("Weather for %s: \n %s%n", cityName, response);
    }
}
