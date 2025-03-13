package eu.ciambella.toilettest.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRatpWebService {

    companion object {
        private const val BASE_URL = "https://data.ratp.fr/api/records/1.0/search/"
    }

    val api: DataRatpApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(DataRatpApiService::class.java)
    }

}
