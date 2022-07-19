package com.vogella.android.codingtest;

import android.app.Application;

public class App extends Application {
    private static ApiRequest mainApi = null;

    @Override
    public void onCreate() {
        super.onCreate();
        initApi();
    }
    private void initApi() {
        if(mainApi == null) {
            mainApi = new Api(UrlConstant.BASE_URL).provideApiCall();
        }
    }
    public static ApiRequest getApi() {
        if(mainApi == null) {
            mainApi = new Api(UrlConstant.BASE_URL).provideApiCall();
        }
        return mainApi;
    }
}
