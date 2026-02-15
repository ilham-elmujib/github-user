package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import entity.RepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<RepoEntity>)

    @Query("SELECT * FROM repositories WHERE owner_login = :login")
    fun getByUserLogin(login: String): Flow<List<RepoEntity>>

    @Query("DELETE FROM repositories")
    suspend fun deleteAll()
}