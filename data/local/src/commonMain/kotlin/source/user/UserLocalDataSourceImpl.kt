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

    override suspend fun update(user: UserEntity) {
        dao.update(user)
    }

    override fun getAll(): Flow<List<UserEntity>> {
        return dao.getAll()
    }

    override fun getByName(query: String): Flow<List<UserEntity>> {
        return dao.getByName(query)
    }


    override suspend fun getDetail(login: String): Flow<UserEntity> {
        return dao.getDetail(login)
    }
}