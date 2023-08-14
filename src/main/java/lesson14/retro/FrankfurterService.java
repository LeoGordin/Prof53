package lesson14.retro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FrankfurterService {

    // https://api.frankfurter.app      - сервер
    //      /latest                     - вебсервис
    //      ?amount=100&from=EUR&to=USD - параметры запроса


    @GET("/latest") // с помощью http метода GET вызваем этот вебсервис
    public Call<CurrencyExchange> convert(
            @Query("amount") int amount,
            @Query("from")String from,
            @Query("to") String to
    );
}
