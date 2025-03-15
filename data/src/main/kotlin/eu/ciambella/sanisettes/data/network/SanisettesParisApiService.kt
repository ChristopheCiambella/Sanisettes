package eu.ciambella.sanisettes.data.network

import eu.ciambella.sanisettes.data.network.response.SanisettesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SanisettesParisApiService {

    @GET("records")
    suspend fun getSanisettes(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): SanisettesResponse

}
