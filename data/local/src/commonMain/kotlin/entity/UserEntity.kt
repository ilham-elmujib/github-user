package entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val login: String?,
    val nodeId: String?,
    val avatarUrl: String?,
    val gravatarId: String?,
    val url: String?,
    val htmlUrl: String?,
    val followersUrl: String?,
    val followingUrl: String?,
    val gistsUrl: String?,
    val starredUrl: String?,
    val subscriptionsUrl: String?,
    val organizationsUrl: String?,
    val reposUrl: String?,
    val eventsUrl: String?,
    val receivedEventsUrl: String?,
    val type: String?,
    val userViewType: String?,
    val siteAdmin: Boolean?
)