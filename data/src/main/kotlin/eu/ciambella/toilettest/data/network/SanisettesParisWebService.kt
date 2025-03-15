package eu.ciambella.toilettest.data.network

import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class SanisettesParisWebService(
    private val json: Json
) {

    companion object {
        private const val BASE_URL = "https://data.ratp.fr/api/explore/v2.1/catalog/datasets/sanisettesparis2011/"
    }

    val api: SanisettesParisApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
            .create(SanisettesParisApiService::class.java)
    }

}
