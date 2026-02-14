package feature.repo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import feature.repo.screen.RepoScreen
import kotlinx.serialization.Serializable

@Serializable
data class RepoRoute(val login: String)

fun NavGraphBuilder.repoGraph(navController: NavController) {
    composable<RepoRoute> { backStackEntry ->
        RepoScreen(
            navigateToBack = {
                navController.popBackStack()
            }
        ).Content()
    }
}