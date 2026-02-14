package model

data class Repo(
    val id: Long,
    val name: String,
    val fullName: String,
    val htmlUrl: String,
    val description: String,
    val language: String,
    val watchersCount: Int,
    val stargazersCount: Int,
    val forksCount: Int,
)
