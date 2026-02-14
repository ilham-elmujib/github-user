package navigation

import BaseNavigation
import androidx.navigation.NavType
import androidx.navigation.navArgument

object RepoNavigation : BaseNavigation() {
    override val route = "repos"
    const val USER_ID = "userId"

    override val arguments = listOf(
        navArgument(USER_ID) { type = NavType.StringType }
    )

    fun createRoute(userId: String) = "$route/$userId"
}

//fun NavGraphBuilder.reposGraph(navController: NavController) {
//    composable(
//        route = ReposNavigation.destination,
//        arguments = ReposNavigation.arguments
//    ) { backStackEntry ->
//        val userId = backStackEntry.arguments?.getString(ReposNavigation.ARG_USER_ID)
//            ?: throw IllegalStateException("User ID is required")
//
//        ReposScreenDestination(
//            UserId = userId,
//            navController = navController
//        )
//    }
//}