package eu.ciambella.sanisettes.data.network

import eu.ciambella.sanisettes.data.network.response.RecordsResponse
import eu.ciambella.sanisettes.data.network.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DataRATPParisApiService {

    @GET("explore/v2.1/catalog/datasets/sanisettesparis2011/records")
    suspend fun getRecords(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): RecordsResponse

    @GET("records/1.0/search/")
    suspend fun search(
        @Query("dataset") dataset: String,
        @Query("geofilter.distance") geoFilter: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): SearchResponse
}
