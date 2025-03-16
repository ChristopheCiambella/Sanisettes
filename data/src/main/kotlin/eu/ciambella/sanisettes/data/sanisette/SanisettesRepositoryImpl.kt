package eu.ciambella.sanisettes.data.sanisette

import eu.ciambella.sanisettes.data.sanisette.datastore.RecordsDatastore
import eu.ciambella.sanisettes.data.sanisette.datastore.SearchDatastore
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SanisettesRepositoryImpl(
    private val recordsDatastore: RecordsDatastore,
    private val searchDatastore: SearchDatastore
) : SanisettesRepository {

    override suspend fun getSanisettes(
        offset: Int
    ): Sanisettes = recordsDatastore.getRecords(offset)

    override suspend fun searchSanisettes(
        location: Location
    ): Sanisettes = searchDatastore.search(location)
}
