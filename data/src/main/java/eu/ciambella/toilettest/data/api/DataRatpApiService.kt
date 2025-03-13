package eu.ciambella.toilettest.data.api

import eu.ciambella.toilettest.data.api.response.RecordsResponse
import retrofit2.Call
import retrofit2.http.GET

interface DataRatpApiService {

    @GET("?dataset=sanisettesparis2011")
    fun getToilets(): Call<RecordsResponse>

}
