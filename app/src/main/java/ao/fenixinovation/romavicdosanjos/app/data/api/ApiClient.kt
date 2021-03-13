package ao.fenixinovation.romavicdosanjos.app.data.api

import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface ApiClient {

    object RetrofitBuilder {

        private val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logger)
            .build()

        private var getRetrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoints = getRetrofit.create(ApiClient::class.java)
    }

    @GET("/photos")
    suspend fun gePhotosEndpoint(): MutableList<ModelsPhotosItem>
}