package feature.repo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.repo.screen.RepoScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import utils.UrlHandler

@Serializable
data class RepoRoute(val login: String)

fun NavGraphBuilder.repoGraph(navController: NavController) {
    composable<RepoRoute> { _ ->
        val urlHandler : UrlHandler = koinInject<UrlHandler>()
        RepoScreen(
            navigateToBack = {
                navController.popBackStack()
            },
            navigateToBrowser = {
                urlHandler.openUrl(it)
            }
        ).Content()
    }
}