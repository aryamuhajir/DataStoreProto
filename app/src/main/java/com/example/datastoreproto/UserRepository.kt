package com.example.datastoreproto

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

class UserRepository (context: Context) {
    private val dataStore : DataStore<UserPreferences> = context.createDataStore(
        "userData",
        serializer = UserSerializer()
    )

    val readProto : Flow<UserPreferences> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading sort order preferences.", exception)
                emit(UserPreferences.getDefaultInstance())
            } else {
                throw exception
            }
        }

    suspend fun updateData(nama : String){
        dataStore.updateData { pref ->
            pref.toBuilder().setName(nama).build()
        }
    }
}