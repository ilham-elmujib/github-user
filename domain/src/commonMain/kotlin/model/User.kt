package model

data class User(
    val id: Int,
    val login: String,
    val htmlUrl: String,
    val avatarUrl: String,
    val name: String,
    val location: String,
    val company: String,
    val blog: String,
    val email: String,
    val bio: String,
    val publicRepos: Int,
    val followers: Int,
    val following: Int
)
