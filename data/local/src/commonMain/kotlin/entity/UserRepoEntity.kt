package entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded

@Entity(tableName = "user_repos")
data class UserRepoEntity(
    @PrimaryKey val id: Long,
    val nodeId: String?,
    val name: String?,
    val fullName: String?,
    val isPrivate: Boolean,
    val htmlUrl: String?,
    val description: String?,
    val isFork: Boolean,
    val url: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val pushedAt: String?,
    val homepage: String?,
    val size: Int,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String?,
    val forksCount: Int,
    val archived: Boolean,
    val disabled: Boolean,
    val openIssuesCount: Int,
    val visibility: String?,
    val defaultBranch: String?,
    val ownerLogin: String?,
    val ownerAvatarUrl: String?,
    @Embedded(prefix = "owner_")
    val owner: UserEntity?,
    @Embedded(prefix = "license_")
    val license: UserRepoLicenseEntity?,
    val topics: String?
)

