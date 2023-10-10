package com.example.examen.data.network

import com.example.examen.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Modelo de red genérico para interactuar con servicios API.
 *
 * Este objeto proporciona una manera de crear instancias de servicios API configuradas para comunicarse con diversas APIs.
 */
object NetworkModule {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    /**
     * Crea una instancia de un servicio API configurada para una API específica.
     *
     * @param apiServiceClass La clase de la interfaz del servicio API.
     * @return Una instancia del servicio API especificado.
     */
    operator fun <T> invoke(apiServiceClass: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + Constants.TOKEN)
                    .build()
                chain.proceed(request)
            })
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.SERVER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(apiServiceClass)
    }
}
