package model

data class UserRepo(
    val user: User,
    val repos: List<Repo>
)
