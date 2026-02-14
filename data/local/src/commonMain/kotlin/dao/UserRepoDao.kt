package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import entity.UserRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<UserRepoEntity>)

    @Query("SELECT * FROM user_repos")
    fun getAll(): Flow<List<UserRepoEntity>>

    @Query("DELETE FROM user_repos")
    suspend fun deleteAll()
}