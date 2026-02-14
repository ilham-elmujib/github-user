package mapper

import entity.RepoEntity
import extensions.orEmpty
import model.Repo
import response.RepoResponse

fun RepoResponse.toEntity(): RepoEntity {
    return RepoEntity(
        id = this.id,
        nodeId = this.nodeId,
        name = this.name,
        fullName = this.fullName,
        isPrivate = this.isPrivate,
        htmlUrl = this.htmlUrl,
        description = this.description,
        isFork = this.isFork,
        url = this.url,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        pushedAt = this.pushedAt,
        homepage = this.homepage,
        size = this.size,
        stargazersCount = this.stargazersCount,
        watchersCount = this.watchersCount,
        language = this.language,
        forksCount = this.forksCount,
        archived = this.archived,
        disabled = this.disabled,
        openIssuesCount = this.openIssuesCount,
        visibility = this.visibility,
        defaultBranch = this.defaultBranch,
        owner = this.owner?.toEntity(),
        license = this.license?.toEntity(),
        topics = this.topics?.joinToString(",")
    )
}

fun List<RepoResponse>.toEntities() = this.map { it.toEntity() }

fun RepoEntity.toDomain(): Repo {
    return Repo(
        id = this.id,
        name = this.name.orEmpty(),
        fullName = this.fullName.orEmpty(),
        htmlUrl = this.htmlUrl.orEmpty(),
        description = this.description.orEmpty(),
        language = this.language.orEmpty(),
        watchersCount = this.watchersCount.orEmpty(),
        stargazersCount = this.stargazersCount.orEmpty(),
        forksCount = this.forksCount.orEmpty(),
    )
}

fun List<RepoEntity>.toDomains() = this.map { it.toDomain() }