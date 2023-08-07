package lesson34.currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FrankfurterService {

    // https://api.frankfurter.app      - сервер
    //      /latest                     - вебсервис
    //      ?amount=100&from=EUR&to=USD - параметры запроса


    @GET("/latest") // с помощью http метода GET вызваем этот вебсервис
    public Call<Exchange> convert(
            @Query("amount") double amount,
            @Query("from")String from,
            @Query("to") String to
    );
}