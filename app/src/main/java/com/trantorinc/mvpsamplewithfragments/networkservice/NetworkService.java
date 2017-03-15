package com.trantorinc.mvpsamplewithfragments.networkservice;

import android.database.Observable;
import android.support.v4.util.LruCache;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trantorinc.mvpsamplewithfragments.networkapi.NetworkAPI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.trantorinc.mvpsamplewithfragments.utilities.Constants.BASE_URL;
import static okhttp3.OkHttpClient.Builder;

/**
 * Created by cteegarden on 1/25/16.
 */

public class NetworkService {

    private NetworkAPI networkAPI;
    private OkHttpClient okHttpClient;
    private LruCache<Class<?>, Observable<?>> apiObservables;

    public NetworkService() {
        this(BASE_URL);
    }

    public NetworkService(String baseUrl) {
        okHttpClient = buildClient();
        apiObservables = new LruCache<>(10);

        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        //logging.setLevel(Level.BASIC);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Builder httpClient = new Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS);

        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();

        networkAPI = retrofit.create(NetworkAPI.class);
    }

    /**
     * Method to return the API interface.
     *
     * @return
     */
    public NetworkAPI getAPI() {
        return networkAPI;
    }


    /**
     * Method to build and return an OkHttpClient so we can set/get
     * headers quickly and efficiently.
     *
     * @return
     */
    public OkHttpClient buildClient() {

        Builder builder = new Builder();

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                // Do anything with response here
                //if we ant to grab a specific cookie or something..
                return response;
            }
        });

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //this is where we will add whatever we want to our request headers.
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            }
        });

        return builder.build();
    }

    /**
     * Method to clear the entire cache of observables
     */
    public void clearCache() {
        apiObservables.evictAll();
    }


}