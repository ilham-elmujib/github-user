package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Update
    suspend fun update(user: UserEntity)
    @Query("SELECT * FROM users")
    fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM users WHERE login = :login")
    fun getDetail(login: String): Flow<UserEntity>

}