package mapper

import model.User
import entity.UserEntity
import extensions.orEmpty
import response.UserResponse

fun UserResponse.toEntity(): UserEntity {
    return UserEntity(
        id = this.id ?: 0,
        login = this.login.orEmpty(),
        nodeId = this.nodeId,
        avatarUrl = this.avatarUrl,
        gravatarId = this.gravatarId,
        url = this.url,
        htmlUrl = this.htmlUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gistsUrl = this.gistsUrl,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        organizationsUrl = this.organizationsUrl,
        reposUrl = this.reposUrl,
        eventsUrl = this.eventsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        type = this.type,
        userViewType = this.userViewType,
        siteAdmin = this.siteAdmin ?: false
    )
}

fun List<UserResponse>.toEntities() = this.map { it.toEntity() }

fun UserEntity.toDomain(): User {
    return User(
        id = this.id.orEmpty(),
        name = this.login.orEmpty(),
        avatarUrl = this.avatarUrl.orEmpty(),
    )
}

fun List<UserEntity>.toDomains() = this.map { it.toDomain() }