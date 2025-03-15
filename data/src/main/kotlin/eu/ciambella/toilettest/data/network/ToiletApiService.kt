package eu.ciambella.toilettest.data.network

import eu.ciambella.toilettest.data.network.response.ToiletResponse
import retrofit2.http.GET

interface ToiletApiService {

    @GET("?dataset=sanisettesparis2011")
    suspend fun getToilets(): ToiletResponse

}
