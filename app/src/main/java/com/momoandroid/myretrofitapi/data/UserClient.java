package com.momoandroid.myretrofitapi.data;

import com.momoandroid.myretrofitapi.models.User;
import java.util.List;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static UserClient instance;
    private IUser iUser;

    public UserClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        iUser = retrofit.create(IUser.class);
    }

    public static UserClient getInstance(){
        if (instance == null){
            synchronized (UserClient.class){
                if (instance == null){
                    instance = new UserClient();
                }
            }
        }
        return instance;
    }

    public Single<List<User>> getDataUser(){
        return iUser.getDataUser();
    }

}
