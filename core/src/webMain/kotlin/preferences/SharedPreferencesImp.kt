package preferences

import kotlinx.coroutines.flow.Flow

class SharedPreferencesImp: SharedPreferences {
    override fun getString(key: String): Flow<String?> {
        TODO("Not yet implemented")
    }

    override suspend fun setString(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun getInt(key: String): Flow<Int?> {
        TODO("Not yet implemented")
    }

    override suspend fun setInt(key: String, value: Int) {
        TODO("Not yet implemented")
    }

    override fun getLong(key: String): Flow<Long?> {
        TODO("Not yet implemented")
    }

    override suspend fun setLong(key: String, value: Long) {
        TODO("Not yet implemented")
    }

    override fun getDouble(key: String): Flow<Double?> {
        TODO("Not yet implemented")
    }

    override suspend fun setDouble(key: String, value: Double) {
        TODO("Not yet implemented")
    }

    override fun getBoolean(key: String): Flow<Boolean?> {
        TODO("Not yet implemented")
    }

    override suspend fun setBoolean(key: String, value: Boolean) {
        TODO("Not yet implemented")
    }
}