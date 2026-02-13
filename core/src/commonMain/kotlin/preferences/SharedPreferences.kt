package preferences

import kotlinx.coroutines.flow.Flow

interface SharedPreferences {
    fun getString(key: String): Flow<String?>
    suspend fun setString(key: String, value: String)
    fun getInt(key: String): Flow<Int?>
    suspend fun setInt(key: String, value: Int)
    fun getLong(key: String): Flow<Long?>
    suspend fun setLong(key: String, value: Long)
    fun getDouble(key: String): Flow<Double?>
    suspend fun setDouble(key: String, value: Double)
    fun getBoolean(key: String): Flow<Boolean?>
    suspend fun setBoolean(key: String, value: Boolean)
}