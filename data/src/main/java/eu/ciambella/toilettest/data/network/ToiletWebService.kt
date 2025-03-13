package eu.ciambella.toilettest.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ToiletWebService {

    companion object {
        private const val BASE_URL = "https://data.ratp.fr/api/records/1.0/search/"
    }

    val api: ToiletApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ToiletApiService::class.java)
    }

}
