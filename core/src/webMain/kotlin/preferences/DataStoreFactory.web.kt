package preferences

actual class DataStoreFactory {
    actual fun create(): SharedPreferences {
        return SharedPreferencesImp()
    }
}