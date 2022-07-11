package com.vogella.android.codingtest

import com.vogella.android.codingtest.ui.main.EmailModel
import retrofit2.http.GET

interface ApiRequest {
    @GET("/v1/57a3ba0c-621f-4ef5-bbf1-9d54411261ed")
    suspend fun getEmails() : List<EmailModel>
}

