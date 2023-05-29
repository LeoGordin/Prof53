package lesson14.retro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FrankfurterService {

    //https://api.frankfurter.app/ - сервер
    // latest - вебсервис
    // ?amount=10&from=GBP&to=USD - параметры запроса
    @GET("/latest") // с помощью http метода GET вызваем этот вебсервис
    public Call<CurrencyExchange> convert(
            @Query("Amount") int amount,
            @Query("From") String from,
            @Query("To") String to
    );
}
