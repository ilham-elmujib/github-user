package preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharedPreferencesImpl(
    private val dataStore: DataStore<Preferences>,
): SharedPreferences {

    override suspend fun setString(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    override fun getString(key: String): Flow<String?> {
        val dataStoreKey = stringPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }


    override suspend fun setLong(key: String, value: Long) {
        val dataStoreKey = longPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    override fun getLong(key: String): Flow<Long?> {
        val dataStoreKey = longPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }

    override suspend fun setInt(key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    override fun getInt(key: String): Flow<Int?> {
        val dataStoreKey = intPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }

    override suspend fun setDouble(key: String, value: Double) {
        val dataStoreKey = doublePreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    override fun getDouble(key: String): Flow<Double?> {
        val dataStoreKey = doublePreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }

    override suspend fun setBoolean(key: String, value: Boolean) {
        val dataStoreKey = booleanPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    override fun getBoolean(key: String): Flow<Boolean?> {
        val dataStoreKey = booleanPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }
}