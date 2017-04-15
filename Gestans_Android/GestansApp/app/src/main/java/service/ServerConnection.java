package service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rebeca on 11/04/2017.
 */

public class ServerConnection {
    private static final String URL_BASE = 
        "http://192.168.0.103:8080/RestEasyApp/";



    private static APIServices service;
    private static ServerConnection selfInstance = new ServerConnection();

    public static ServerConnection getInstance() {
        return selfInstance;
    }

    public APIServices getService() {
        return service;
    }

    private ServerConnection() {
        updateServiceAdress();
    }

    public void updateServiceAdress() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(APIServices.class);
    }
}

