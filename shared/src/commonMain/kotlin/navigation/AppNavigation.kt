package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import feature.repo.navigation.repoGraph
import feature.user.navigation.UserRoute
import feature.user.navigation.userGraph

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = UserRoute
    ) {
        userGraph(navController)
        repoGraph(navController)
    }
}