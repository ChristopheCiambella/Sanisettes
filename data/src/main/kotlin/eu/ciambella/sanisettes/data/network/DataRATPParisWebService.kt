package eu.ciambella.sanisettes.data.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class DataRATPParisWebService(
    private val json: Json
) {

    companion object {
        private const val BASE_URL = "https://data.ratp.fr/api/"
    }

    val api: DataRATPParisApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
            .create(DataRATPParisApiService::class.java)
    }
}
