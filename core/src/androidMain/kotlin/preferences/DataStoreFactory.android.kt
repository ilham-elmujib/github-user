package preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

actual class DataStoreFactory(
    private val context: Context,
) {

    actual fun create(): SharedPreferences {
        val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
            produceFile = { context.filesDir.resolve(SharedPreferencesKey.FILE_NAME).absolutePath.toPath() }
        )
        return SharedPreferencesImpl(dataStore)

    }
}