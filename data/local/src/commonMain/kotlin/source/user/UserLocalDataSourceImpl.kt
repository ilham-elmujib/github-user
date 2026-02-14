package source.user

import dao.UserDao
import entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserLocalDataSourceImpl(
    private val dao: UserDao
) : UserLocalDataSource {
    override suspend fun saveAll(users: List<UserEntity>) {
        dao.insertAll(users)
    }

    override fun getAll(): Flow<List<UserEntity>> {
        return dao.getAll()
    }
}