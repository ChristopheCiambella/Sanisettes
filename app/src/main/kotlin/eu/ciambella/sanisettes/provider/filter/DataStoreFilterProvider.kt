package eu.ciambella.sanisettes.provider.filter

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import eu.ciambella.sanisettes.domain.settings.FilterProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DataStoreFilterProvider(
    private val dataStore: DataStore<Preferences>,
) : FilterProvider {

    companion object {
        private val PMR_FILTER = booleanPreferencesKey("pmr_filter")
    }

    override val isPmrOnly: Flow<Boolean> = dataStore.data
        .catch { emit(emptyPreferences()) }
        .map { preferences ->
            preferences[PMR_FILTER] ?: false
        }

    override suspend fun setPmrOnly(value: Boolean) {
        dataStore.edit { preferences ->
            preferences[PMR_FILTER] = value
        }
    }
}
