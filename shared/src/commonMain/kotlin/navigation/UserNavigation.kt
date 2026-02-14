package navigation

import BaseNavigation
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.user.screen.UserScreen

object UserNavigation : BaseNavigation() {
    override val route = "users"
}

fun NavGraphBuilder.usersGraph(navController: NavController) {
    composable(route = UserNavigation.destination) {
        UserScreen().Content(navController)
    }
}