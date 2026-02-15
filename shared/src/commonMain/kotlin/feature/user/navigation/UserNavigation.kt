package feature.user.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.repo.navigation.RepoRoute
import feature.user.screen.UserScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import utils.UrlHandler

@Serializable
object UserRoute

fun NavGraphBuilder.userGraph(navController: NavController) {
    composable<UserRoute> {
        val urlHandler: UrlHandler = koinInject<UrlHandler>()
        UserScreen(
            navigateToRepo = {
                navController.navigate(RepoRoute(it))
            },
            navigateToBrowser = {
                urlHandler.openUrl(it)
            }
        ).Content()
    }
}