package lesson34.currency;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Converter {

    public static void main(String[] args) {
        // 100 USD->EUR
        CompletableFuture<Double> sequential = CompletableFuture.supplyAsync(
                () -> convert(100, "USD", "EUR")
        ).thenApply(
                amount -> convert(amount, "EUR", "GBP")
        ).exceptionally(
                t -> {
                    System.out.println("Exception" + t.getCause());
                    return 0.0;
                }
                );
        // 97.. EUR->GBP
    }

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.frankfurter.app") // сервер
            // чтобы json автоматически конвертировался в класс
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static FrankfurterService service = retrofit.create(FrankfurterService.class);

    static double convert(double amount, String from, String to)
    {
        try {
            Response<Exchange> response = service.convert(amount, from, to).execute();
            return response.body().rates.get(to);
        } catch (IOException e) {
            throw new CompletionException(e);
        }
    }
}



