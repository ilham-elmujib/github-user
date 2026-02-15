package repository

import app.cash.turbine.test
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import mapper.toDomains
import mapper.toEntities
import repository.user.UserRepository
import repository.user.UserRepositoryImpl
import response.UserResponse
import source.user.UserLocalDataSource
import source.user.UserRemoteDataSource
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRepositoryTest {

    private val remote = mock<UserRemoteDataSource>()
    private val local = mock<UserLocalDataSource>()
    private val repository = UserRepositoryImpl(remote, local)

    @Test
    fun `getAll should fetch from remote and save to local`() = runTest {
        // Data Mock
        val expectedResponse = listOf(UserResponse(id = 1, name = "Suraes"))
        val expectedEntities = expectedResponse.toEntities()
        val expectedDomains = expectedEntities.toDomains()

        //  Mocking Behaviors
        everySuspend { remote.getAll() } returns expectedResponse
        everySuspend { local.saveAll(any()) } returns Unit
        every { local.getAll() } returns flowOf(expectedEntities)

        // Execution & Validation
        repository.getAll().test {
            val result = awaitItem()
            assertEquals(expectedDomains, result)
            awaitComplete()
        }

        // Strict Verification
        verify {
            suspend { remote.getAll() }
            suspend { local.saveAll(expectedEntities) }
        }
    }
}