package preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import java.io.File

actual class DataStoreFactory {
    actual fun create(): SharedPreferences {
        val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
            produceFile = {
                val dsDir = File(System.getProperty("user.home"), "github-user")
                if (!dsDir.exists()) {
                    dsDir.mkdirs()
                }
                File(dsDir, SharedPreferencesKey.FILE_NAME).absolutePath.toPath()
            }
        )
        return SharedPreferencesImp(dataStore)
    }
}