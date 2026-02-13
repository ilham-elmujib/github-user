package preferences

expect class DataStoreFactory {
    fun create(): SharedPreferences
}