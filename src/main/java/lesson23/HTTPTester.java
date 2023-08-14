package lesson23;

import com.google.gson.Gson;
import lesson14.retro.Rate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpTester {
    public static void main(String[] args) {
        String webService = "https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD";
        StringBuilder builder = new StringBuilder();
        try
        {
            URL url = new URL(webService);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try (
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(isr);
                    )
            {
                br.lines().forEach(builder::append);
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(builder.toString());

        // с помощью Gson создайте на базе возвращенного значения экземпляр
        // класса CurrencyRate
        Gson gson = new Gson();
        CurrencyRate rate = gson.fromJson(builder.toString(), CurrencyRate.class);
        System.out.println(rate);


    }
}
class CurrencyRate {
    public double amount;
    public String base;
    public String date;
    public Map<String, Double> rates = new HashMap<>();

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "amount=" + amount +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }
}
