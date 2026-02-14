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
        siteAdmin = this.siteAdmin ?: false,
        name = this.name,
        company = this.company,
        blog = this.blog,
        location = this.location,
        email = this.email,
        hireable = this.hireable,
        bio = this.bio,
        twitterUsername = this.twitterUsername,
        publicRepos = this.publicRepos,
        publicGists = this.publicGists,
        followers = this.followers,
        following = this.following,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

fun List<UserResponse>.toEntities() = this.map { it.toEntity() }

fun UserEntity.toDomain(): User {
    return User(
        id = this.id.orEmpty(),
        login = this.login.orEmpty(),
        avatarUrl = this.avatarUrl.orEmpty(),
        htmlUrl = this.htmlUrl.orEmpty(),
        name = this.name.orEmpty(),
        company = this.company.orEmpty(),
        blog = this.blog.orEmpty(),
        location = this.location.orEmpty(),
        email = this.email.orEmpty(),
        bio = this.bio.orEmpty(),
        publicRepos = this.publicRepos.orEmpty(),
        followers = this.followers.orEmpty(),
        following = this.following.orEmpty(),
    )
}

fun List<UserEntity>.toDomains() = this.map { it.toDomain() }