import androidx.navigation.NamedNavArgument

/**
 * Base class for all navigation destinations.
 * It automatically handles route construction for destinations with arguments.
 */
abstract class BaseNavigation {
    // The base path of the route (e.g., "users")
    abstract val route: String

    // List of arguments for this specific route
    open val arguments: List<NamedNavArgument> = emptyList()

    /**
     * The full route string used by the NavHost.
     * If arguments exist, it appends them in the format: route/{arg1}/{arg2}
     */
    val destination: String
        get() = if (arguments.isEmpty()) {
            route
        } else {
            val argsPath = arguments.joinToString("/") { "{${it.name}}" }
            "$route/$argsPath"
        }
}