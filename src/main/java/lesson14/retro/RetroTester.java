package lesson14.retro;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetroTester {
    public static void main(String[] args) throws IOException {
        // https://api.frankfurter.app      - сервер
        //      /latest                     - вебсервис
        //      ?amount=100&from=EUR&to=USD - параметры запроса

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.frankfurter.app") // сервер
                // чтобы json автоматически конвертировался в класс
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // создать экземпляр сервиса из интерфейса
        FrankfurterService service = retrofit.create(FrankfurterService.class);

        Call<CurrencyExchange> call = service.convert(1000, "EUR", "USD");
        Response<CurrencyExchange> response = call.execute();
        if(response.isSuccessful())
        {
            CurrencyExchange exchange = response.body();
            System.out.println(exchange.rates.USD);
        }
        System.exit(0);


    }
}
