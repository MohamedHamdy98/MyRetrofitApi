package com.momoandroid.myretrofitapi.data;

import com.momoandroid.myretrofitapi.models.User;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface IUser {
    @GET("users")
    Single<List<User>> getDataUser();
}
