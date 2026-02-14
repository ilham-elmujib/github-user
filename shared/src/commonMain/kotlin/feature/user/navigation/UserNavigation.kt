package feature.user.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.repo.navigation.RepoRoute
import feature.user.screen.UserScreen
import kotlinx.serialization.Serializable

@Serializable
object UserRoute

fun NavGraphBuilder.userGraph(navController: NavController) {
    composable<UserRoute> {
        UserScreen(
            navigateToRepo = {
                navController.navigate(RepoRoute(it))
            }
        ).Content()
    }
}