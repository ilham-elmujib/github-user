package co.id.ilhamelmujib.githubuser.model

data class User(
    val login: String,
    val id: Long,
    val name: String,
    val bio: String,
    val fullName: String,
    val avatarUrl: String
)
