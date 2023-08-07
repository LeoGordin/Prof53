package lesson34;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCompose {
    public static void main(String[] args) {
        CompletableFuture<UserRating> rating =
                getUserInfo(122)
                        .thenCompose(info -> getUserRating(info));

        CompletableFuture<CompletableFuture<UserRating>> complexRating =
                getUserInfo(122)
                        .thenApply(info -> getUserRating(info));
    }

    static CompletableFuture<UserInfo> getUserInfo(int userId) {
        return CompletableFuture.supplyAsync(() -> new UserInfo(userId));
    }

    static CompletableFuture<UserRating> getUserRating(UserInfo info) {
        return CompletableFuture.supplyAsync(() -> new UserRating(info));
    }
}

    class UserRating {
        private UserInfo info;

        public UserRating(UserInfo info) {
            this.info = info;
        }
    }

    class UserInfo {
        private int userId;

        public UserInfo(int userId) {
            this.userId = userId;
        }
    }